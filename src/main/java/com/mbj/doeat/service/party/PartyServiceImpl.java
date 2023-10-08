package com.mbj.doeat.service.party;

import com.mbj.doeat.dto.party.PartyCreateRequestDto;
import com.mbj.doeat.dto.party.PartyCreateResponseDto;
import com.mbj.doeat.dto.user.UserIdRequestDto;
import com.mbj.doeat.entity.Party;
import com.mbj.doeat.entity.User;
import com.mbj.doeat.mapper.party.PartyMapper;
import com.mbj.doeat.repository.PartyRepository;
import com.mbj.doeat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {

    private final PartyRepository partyRepository;
    private final UserRepository userRepository;

    @Override
    public PartyCreateResponseDto createParty(PartyCreateRequestDto requestDto) {
        Optional<User> findUser = userRepository.findById(requestDto.getUserId());

        if (findUser.isEmpty()) {
            return null;
        } else {
            User user = findUser.get();
            Party party = PartyMapper.mapToEntity(requestDto, user);
            Party savedParty = partyRepository.save(party);
            return PartyMapper.mapToResponseDto(savedParty);
        }
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

    @Override
    public List<PartyCreateResponseDto> getMyParties(UserIdRequestDto userIdRequestDto) {
        List<Party> parties = partyRepository.findByUserUserId(userIdRequestDto.getUserId());
        return parties.stream()
                .map(PartyMapper::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteParty(Long partyId) {
        partyRepository.deleteById(partyId);
    }
}