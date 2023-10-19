package com.mbj.doeat.service.user;

import com.mbj.doeat.dto.user.FindUserRequestDto;
import com.mbj.doeat.dto.user.UserCreateRequestDto;
import com.mbj.doeat.dto.user.UserCreateResponseDto;

import java.util.List;

public interface UserService {

    UserCreateResponseDto findUser(FindUserRequestDto findUserRequestDto);

    UserCreateResponseDto createUser(UserCreateRequestDto userCreateRequestDto);

    UserCreateResponseDto updateUser(UserCreateResponseDto userCreateResponseDto, UserCreateRequestDto userCreateRequestDto);

    List<UserCreateResponseDto> getAllUser();

    void deleteUser(Long userId);
}
