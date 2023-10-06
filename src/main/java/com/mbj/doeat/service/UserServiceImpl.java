package com.mbj.doeat.service;

import com.mbj.doeat.dto.user.UserRequestDto;
import com.mbj.doeat.entity.User;
import com.mbj.doeat.mapper.user.UserMapper;
import com.mbj.doeat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByKakaoUserId(String kakaoUserId) {
        return userRepository.findByKakaoUserId(kakaoUserId);
    }

    @Override
    public User createUser(UserRequestDto userRequestDto) {
        User newUser = UserMapper.toUser(userRequestDto);
        return userRepository.save(newUser);
    }

    @Override
    public void updateUser(User user, UserRequestDto userRequestDto) {
        user.setKakaoUserId(userRequestDto.getKakaoUserId());
        user.setNickname(userRequestDto.getUserNickname());
        user.setImageUrl(userRequestDto.getUserImageUrl());
        userRepository.save(user);
    }
}