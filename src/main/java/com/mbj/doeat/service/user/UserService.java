package com.mbj.doeat.service.user;

import com.mbj.doeat.dto.user.FindUserRequestDto;
import com.mbj.doeat.dto.user.UserCreateRequestDto;
import com.mbj.doeat.dto.user.UserCreateResponseDto;

public interface UserService {

    UserCreateResponseDto findUser(FindUserRequestDto findUserRequestDto);

    UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto);

    UserCreateResponseDto updateUser(UserCreateResponseDto userCreateResponseDto, UserCreateRequestDto userCreateRequestDto);

    void deleteUser(Long userId);
}
