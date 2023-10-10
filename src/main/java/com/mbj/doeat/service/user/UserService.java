package com.mbj.doeat.service.user;

import com.mbj.doeat.dto.user.UserCreateRequestDto;
import com.mbj.doeat.dto.user.UserCreateResponseDto;

public interface UserService {

    UserCreateResponseDto findUser(Long kakaoUserId);

    UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto);

    UserCreateResponseDto updateUser(UserCreateResponseDto userCreateResponseDto, UserCreateRequestDto userCreateRequestDto);

    void deleteUser(Long userId);
}
