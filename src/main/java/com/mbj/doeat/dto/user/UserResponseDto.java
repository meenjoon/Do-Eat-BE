package com.mbj.doeat.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {

    private Long userId;
    private String kakaoUserId;
    private String userNickname;
    private String userImageUrl;
}
