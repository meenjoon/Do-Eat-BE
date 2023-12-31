package com.mbj.doeat.mapper.party;

import com.mbj.doeat.dto.party.PartyCreateRequestDto;
import com.mbj.doeat.dto.party.PartyCreateResponseDto;
import com.mbj.doeat.entity.Party;
import com.mbj.doeat.entity.User;

public class PartyMapper {

    public static Party mapToEntity(PartyCreateRequestDto requestDto, User user) {
        Party party = new Party();
        party.setUser(user);
        party.setRestaurantName(requestDto.getRestaurantName());
        party.setRestaurantLocation(requestDto.getRestaurantLocation());
        party.setRecruitmentLimit(requestDto.getRecruitmentLimit());
        party.setCurrentNumberPeople(requestDto.getCurrentNumberPeople());
        party.setRestaurantCategory(requestDto.getCategory());
        party.setRestaurantLink(requestDto.getLink());
        if (requestDto.getDetail() != null) {
            party.setDetail(requestDto.getDetail());
        }
        return party;
    }

    public static PartyCreateResponseDto mapToResponseDto(Party party) {
        PartyCreateResponseDto responseDto = new PartyCreateResponseDto();
        responseDto.setPostId(party.getPostId());
        responseDto.setUserId(party.getUser().getUserId());
        responseDto.setRestaurantName(party.getRestaurantName());
        responseDto.setRestaurantLocation(party.getRestaurantLocation());
        responseDto.setRecruitmentLimit(party.getRecruitmentLimit());
        responseDto.setCurrentNumberPeople(party.getCurrentNumberPeople());
        responseDto.setCategory(party.getRestaurantCategory());
        responseDto.setLink(party.getRestaurantLink());
        responseDto.setDetail(party.getDetail() != null ? party.getDetail() : "");
        return responseDto;
    }
}
