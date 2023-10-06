package com.mbj.doeat.service.user;

import com.mbj.doeat.dto.user.UserRequestDto;
import com.mbj.doeat.dto.user.UserResponseDto;
import com.mbj.doeat.entity.User;
import com.mbj.doeat.mapper.user.UserMapper;
import com.mbj.doeat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto findUser(String kakaoUserId) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByKakaoUserId(kakaoUserId));
        return userOptional.map(user ->
                        new UserResponseDto(user.getUserId(), user.getKakaoUserId(), user.getNickname(), user.getImageUrl()))
                .orElse(null);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User newUser = UserMapper.toUser(userRequestDto);
        userRepository.save(newUser);
        return findUser(userRequestDto.getKakaoUserId());
    }

    @Override
    public UserResponseDto updateUser(UserResponseDto userResponseDto, UserRequestDto userRequestDto) {
        userResponseDto.setKakaoUserId(userRequestDto.getKakaoUserId());
        userResponseDto.setUserNickname(userRequestDto.getUserNickname());
        userResponseDto.setUserImageUrl(userRequestDto.getUserImageUrl());

        User updatedUser = UserMapper.userResponseDtoToUser(userResponseDto);
        userRepository.save(updatedUser);
        return userResponseDto;
    }
}