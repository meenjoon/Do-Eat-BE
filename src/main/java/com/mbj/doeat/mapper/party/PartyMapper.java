package com.mbj.doeat.mapper.party;

import com.mbj.doeat.dto.party.PartyCreateRequestDto;
import com.mbj.doeat.dto.party.PartyCreateResponseDto;
import com.mbj.doeat.entity.Party;

public class PartyMapper {

    public static Party mapToEntity(PartyCreateRequestDto requestDto) {
        Party party = new Party();
        party.setUserId(requestDto.getUserId());
        party.setRestaurantName(requestDto.getRestaurantName());
        party.setRestaurantLocation(requestDto.getRestaurantLocation());
        party.setRecruitmentLimit(requestDto.getRecruitmentLimit());
        if (requestDto.getDetail() != null) {
            party.setDetail(requestDto.getDetail());
        }
        return party;
    }

    public static PartyCreateResponseDto mapToResponseDto(Party party) {
        PartyCreateResponseDto responseDto = new PartyCreateResponseDto();
        responseDto.setPostId(party.getPostId());
        responseDto.setUserId(party.getUserId());
        responseDto.setRestaurantName(party.getRestaurantName());
        responseDto.setRestaurantLocation(party.getRestaurantLocation());
        responseDto.setRecruitmentLimit(party.getRecruitmentLimit());
        responseDto.setDetail(party.getDetail() != null ? party.getDetail() : "");
        return responseDto;
    }
}
