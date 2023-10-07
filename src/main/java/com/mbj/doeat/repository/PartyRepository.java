package com.mbj.doeat.repository;

import com.mbj.doeat.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyRepository extends JpaRepository<Party, Long> {

    List<Party> findByRestaurantLocation(String restaurantLocation);

    List<Party> findByUserUserId(Long userId);
}
