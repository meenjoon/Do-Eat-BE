package com.mbj.doeat.dto.party;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PartyCreateResponseDto {

    private Long postId;
    private Long userId;
    private String restaurantName;
    private String restaurantLocation;
    private Integer recruitmentLimit;
    private String detail;
}
