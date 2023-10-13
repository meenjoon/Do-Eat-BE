package com.mbj.doeat.service.user;

import com.mbj.doeat.dto.user.FindUserRequestDto;
import com.mbj.doeat.dto.user.UserCreateRequestDto;
import com.mbj.doeat.dto.user.UserCreateResponseDto;
import com.mbj.doeat.entity.User;
import com.mbj.doeat.mapper.user.UserMapper;
import com.mbj.doeat.repository.PartyRepository;
import com.mbj.doeat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PartyRepository partyRepository;

    @Override
    public UserCreateResponseDto findUser(FindUserRequestDto findUserRequestDto) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByKakaoUserId(findUserRequestDto.getKakaoUserId()));
        return userOptional.map(user ->
                        new UserCreateResponseDto(user.getUserId(), user.getKakaoUserId(), user.getNickname(), user.getImageUrl()))
                .orElse(null);
    }

    @Override
    public UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto) {
        User newUser = UserMapper.toUser(userCreateRequestDto);
        userRepository.save(newUser);

        FindUserRequestDto findUserRequestDto = UserMapper.toFindUserRequestDto(userCreateRequestDto);
        return findUser(findUserRequestDto);
    }

    @Override
    public UserCreateResponseDto updateUser(UserCreateResponseDto userCreateResponseDto, UserCreateRequestDto userCreateRequestDto) {
        userCreateResponseDto.setKakaoUserId(userCreateRequestDto.getKakaoUserId());
        userCreateResponseDto.setUserNickname(userCreateRequestDto.getUserNickname());
        userCreateResponseDto.setUserImageUrl(userCreateRequestDto.getUserImageUrl());

        User updatedUser = UserMapper.userResponseDtoToUser(userCreateResponseDto);
        userRepository.save(updatedUser);
        return userCreateResponseDto;
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        partyRepository.deleteAllByUserUserId(userId);
        userRepository.deleteById(userId);
    }
}