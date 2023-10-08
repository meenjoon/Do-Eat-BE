package com.mbj.doeat.service.user;

import com.mbj.doeat.dto.user.UserCreateRequestDto;
import com.mbj.doeat.dto.user.UserResponseDto;
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
    public UserResponseDto findUser(String kakaoUserId) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByKakaoUserId(kakaoUserId));
        return userOptional.map(user ->
                        new UserResponseDto(user.getUserId(), user.getKakaoUserId(), user.getNickname(), user.getImageUrl()))
                .orElse(null);
    }

    @Override
    public UserResponseDto createUser(UserCreateRequestDto userCreateRequestDto) {
        User newUser = UserMapper.toUser(userCreateRequestDto);
        userRepository.save(newUser);
        return findUser(userCreateRequestDto.getKakaoUserId());
    }

    @Override
    public UserResponseDto updateUser(UserResponseDto userResponseDto, UserCreateRequestDto userCreateRequestDto) {
        userResponseDto.setKakaoUserId(userCreateRequestDto.getKakaoUserId());
        userResponseDto.setUserNickname(userCreateRequestDto.getUserNickname());
        userResponseDto.setUserImageUrl(userCreateRequestDto.getUserImageUrl());

        User updatedUser = UserMapper.userResponseDtoToUser(userResponseDto);
        userRepository.save(updatedUser);
        return userResponseDto;
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        partyRepository.deleteAllByUserUserId(userId);
        userRepository.deleteById(userId);
    }
}