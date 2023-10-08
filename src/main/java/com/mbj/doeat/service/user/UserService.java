package com.mbj.doeat.service.user;

import com.mbj.doeat.dto.user.UserCreateRequestDto;
import com.mbj.doeat.dto.user.UserResponseDto;

public interface UserService {

    UserResponseDto findUser(String kakaoUserId);

    UserResponseDto createUser(UserCreateRequestDto userCreateRequestDto);

    UserResponseDto updateUser(UserResponseDto userResponseDto, UserCreateRequestDto userCreateRequestDto);

    void deleteUser(Long userId);
}
