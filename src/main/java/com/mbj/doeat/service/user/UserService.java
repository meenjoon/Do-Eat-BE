package com.mbj.doeat.service.user;

import com.mbj.doeat.dto.user.UserRequestDto;
import com.mbj.doeat.entity.User;

public interface UserService {

    User findByKakaoUserId(String kakaoUserId);

    User createUser(UserRequestDto userRequestDto);

    void updateUser(User user, UserRequestDto userRequestDto);
}
