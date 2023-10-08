package com.mbj.doeat.controller;

import com.mbj.doeat.dto.party.PartyCreateRequestDto;
import com.mbj.doeat.dto.party.PartyCreateResponseDto;
import com.mbj.doeat.dto.party.PartyPostIdRequestDto;
import com.mbj.doeat.dto.user.UserIdRequestDto;
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

    @GetMapping("/restaurant/{restaurantLocation}")
    public ResponseEntity<?> getPartiesByLocation(@PathVariable String restaurantLocation) {
        try {
            List<PartyCreateResponseDto> parties = partyService.getPartiesByLocation(restaurantLocation);
            return new ResponseEntity<>(parties, HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "오류가 발생했습니다: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/my-parties")
    public ResponseEntity<?> getMyParties(@RequestBody UserIdRequestDto userIdRequestDto){
        try {
            List<PartyCreateResponseDto> parties = partyService.getMyParties(userIdRequestDto);
            return new ResponseEntity<>(parties, HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "오류가 발생했습니다: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> partyDelete(@RequestBody PartyPostIdRequestDto partyPostIdRequestDto) {
        try {
            partyService.deleteParty(partyPostIdRequestDto.getPartyId());
            return new ResponseEntity<>("삭제 하였습니다.", HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "오류가 발생했습니다: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
