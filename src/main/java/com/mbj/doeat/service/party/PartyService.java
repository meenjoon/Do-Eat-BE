package com.mbj.doeat.service.party;

import com.mbj.doeat.dto.party.PartyCreateRequestDto;
import com.mbj.doeat.dto.party.PartyCreateResponseDto;

public interface PartyService {

    PartyCreateResponseDto createParty(PartyCreateRequestDto requestDto);
}
