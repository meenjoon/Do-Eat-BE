package com.mbj.doeat.mapper.user;

import com.mbj.doeat.dto.user.FindUserRequestDto;
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

    public static FindUserRequestDto toFindUserRequestDto(UserCreateRequestDto userCreateRequestDto) {
        FindUserRequestDto findUserRequestDto = new FindUserRequestDto();
        findUserRequestDto.setKakaoUserId(userCreateRequestDto.getKakaoUserId());
        return findUserRequestDto;
    }

    public static UserCreateResponseDto userToUserCreateResponseDto(User user) {
        UserCreateResponseDto responseDto = new UserCreateResponseDto();
        responseDto.setUserId(user.getUserId());
        responseDto.setKakaoUserId(user.getKakaoUserId());
        responseDto.setUserNickname(user.getNickname());
        responseDto.setUserImageUrl(user.getImageUrl());
        return responseDto;
    }
}