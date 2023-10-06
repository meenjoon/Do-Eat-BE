package com.mbj.doeat.mapper.user;

import com.mbj.doeat.dto.user.UserRequestDto;
import com.mbj.doeat.dto.user.UserResponseDto;
import com.mbj.doeat.entity.User;

public class UserMapper {

    public static User toUser(UserRequestDto requestDto) {
        User user = new User();
        user.setKakaoUserId(requestDto.getKakaoUserId());
        user.setNickname(requestDto.getUserNickname());
        user.setImageUrl(requestDto.getUserImageUrl());
        return user;
    }

    public static UserResponseDto toUserResponseDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setUserId(user.getUserId());
        responseDto.setKakaoUserId(user.getKakaoUserId());
        responseDto.setUserNickname(user.getNickname());
        responseDto.setUserImageUrl(user.getImageUrl());
        return responseDto;
    }
}