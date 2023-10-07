package com.mbj.doeat.controller;

import com.mbj.doeat.dto.party.PartyCreateRequestDto;
import com.mbj.doeat.dto.party.PartyCreateResponseDto;
import com.mbj.doeat.service.party.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/party")
public class PartyController {

    private final PartyService partyService;

    @PostMapping("/post")
    public ResponseEntity<?> partyCreate(@RequestBody PartyCreateRequestDto requestDto) {
        try {
            PartyCreateResponseDto responseDto = partyService.createParty(requestDto);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMessage = "오류가 발생했습니다: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllParties() {
        try {
            List<PartyCreateResponseDto> parties = partyService.getAllParties();
            return new ResponseEntity<>(parties, HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "오류가 발생했습니다: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
