package com.mbj.doeat.mapper.user;

import com.mbj.doeat.dto.user.UserCreateRequestDto;
import com.mbj.doeat.dto.user.UserCreateResponseDto;
import com.mbj.doeat.entity.User;

public class UserMapper {

    public static User toUser(UserCreateRequestDto requestDto) {
        User user = new User();
        user.setKakaoUserId(requestDto.getKakaoUserId());
        user.setNickname(requestDto.getUserNickname());
        user.setImageUrl(requestDto.getUserImageUrl());
        return user;
    }

    public static User userResponseDtoToUser(UserCreateResponseDto responseDto) {
        User user = new User();
        user.setUserId(responseDto.getUserId());
        user.setKakaoUserId(responseDto.getKakaoUserId());
        user.setNickname(responseDto.getUserNickname());
        user.setImageUrl(responseDto.getUserImageUrl());
        return user;
    }
}