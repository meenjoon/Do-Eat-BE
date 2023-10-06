package com.mbj.doeat.service.user;

import com.mbj.doeat.dto.user.UserRequestDto;
import com.mbj.doeat.dto.user.UserResponseDto;

public interface UserService {

    UserResponseDto findUser(String kakaoUserId);

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(UserResponseDto userResponseDto, UserRequestDto userRequestDto);
}
