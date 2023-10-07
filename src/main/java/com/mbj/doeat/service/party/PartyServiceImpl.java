package com.mbj.doeat.service.party;

import com.mbj.doeat.dto.party.PartyCreateRequestDto;
import com.mbj.doeat.dto.party.PartyCreateResponseDto;
import com.mbj.doeat.entity.Party;
import com.mbj.doeat.mapper.party.PartyMapper;
import com.mbj.doeat.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;

    @Override
    public PartyCreateResponseDto createParty(PartyCreateRequestDto requestDto) {
        Party party = PartyMapper.mapToEntity(requestDto);
        Party savedParty = partyRepository.save(party);
        return PartyMapper.mapToResponseDto(savedParty);
    }

    @Override
    public List<PartyCreateResponseDto> getAllParties() {
        List<Party> parties = partyRepository.findAll();
        return parties.stream()
                .map(PartyMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PartyCreateResponseDto> getPartiesByLocation(String restaurantLocation) {
        List<Party> parties = partyRepository.findByRestaurantLocation(restaurantLocation);
        return parties.stream()
                .map(PartyMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }
}