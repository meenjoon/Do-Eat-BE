package com.mbj.doeat.service.party;

import com.mbj.doeat.dto.party.PartyCreateRequestDto;
import com.mbj.doeat.dto.party.PartyCreateResponseDto;
import com.mbj.doeat.dto.user.UserIdRequestDto;

import java.util.List;

public interface PartyService {

    PartyCreateResponseDto createParty(PartyCreateRequestDto requestDto);

    List<PartyCreateResponseDto> getAllParties();

    List<PartyCreateResponseDto> getPartiesByLocation(String restaurantLocation);

    List<PartyCreateResponseDto> getMyParties(UserIdRequestDto userIdRequestDto);

    void deleteParty(Long partyId);
}
