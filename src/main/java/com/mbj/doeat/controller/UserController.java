package com.mbj.doeat.controller;

import com.mbj.doeat.dto.user.UserIdRequestDto;
import com.mbj.doeat.dto.user.UserCreateRequestDto;
import com.mbj.doeat.dto.user.UserCreateResponseDto;
import com.mbj.doeat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<?> signIn(@RequestBody UserCreateRequestDto userCreateRequestDto) {
        Long kakaoUserId = userCreateRequestDto.getKakaoUserId();

        UserCreateResponseDto existingUser;
        try {
            existingUser = userService.findUser(kakaoUserId);
        } catch (Exception e) {
            String errorMessage = "오류가 발생했습니다: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (existingUser == null) {
            try {
                UserCreateResponseDto newUser = userService.createUser(userCreateRequestDto);
                return new ResponseEntity<>(newUser, HttpStatus.CREATED);
            } catch (Exception e) {
                String errorMessage = "오류가 발생했습니다: " + e.getMessage();
                return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            try {
                UserCreateResponseDto updateUser = userService.updateUser(existingUser, userCreateRequestDto);
                return new ResponseEntity<>(updateUser, HttpStatus.OK);
            } catch (Exception e) {
                String errorMessage = "오류가 발생했습니다: " + e.getMessage();
                return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> userDelete(@RequestBody UserIdRequestDto userIdRequestDto) {
        try {
            userService.deleteUser(userIdRequestDto.getUserId());
            return new ResponseEntity<>("삭제 하였습니다.", HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "오류가 발생했습니다: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
