package com.mbj.doeat.dto.party;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PartyCreateRequestDto {

    private Long userId;
    private String restaurantName;
    private String restaurantLocation;
    private Integer recruitmentLimit;
    private String detail;
}
