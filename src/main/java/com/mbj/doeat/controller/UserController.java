package com.mbj.doeat.controller;

import com.mbj.doeat.dto.user.UserRequestDto;
import com.mbj.doeat.dto.user.UserResponseDto;
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

        UserResponseDto existingUser = userService.findUser(kakaoUserId);

        if (existingUser == null) {
            UserResponseDto newUser = userService.createUser(userRequestDto);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } else {
            UserResponseDto updateUser = userService.updateUser(existingUser, userRequestDto);
            return new ResponseEntity<>(updateUser, HttpStatus.OK);
        }
    }
}
