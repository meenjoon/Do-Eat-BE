package com.mbj.doeat.controller;

import com.mbj.doeat.dto.user.UserRequestDto;
import com.mbj.doeat.dto.user.UserResponseDto;
import com.mbj.doeat.entity.User;
import com.mbj.doeat.mapper.user.UserMapper;
import com.mbj.doeat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserResponseDto> signIn(@RequestBody UserRequestDto userRequestDto) {
        String kakaoUserId = userRequestDto.getKakaoUserId();

        User existingUser = userService.findByKakaoUserId(kakaoUserId);

        if (existingUser == null) {
            User newUser = userService.createUser(userRequestDto);
            UserResponseDto responseDto = UserMapper.toUserResponseDto(newUser);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } else {
            userService.updateUser(existingUser, userRequestDto);
            UserResponseDto responseDto = UserMapper.toUserResponseDto(existingUser);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
    }
}
