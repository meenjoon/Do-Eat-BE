package com.mbj.doeat.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateResponseDto {

    private Long userId;
    private Long kakaoUserId;
    private String userNickname;
    private String userImageUrl;
}
