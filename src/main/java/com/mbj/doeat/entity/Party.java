package com.mbj.doeat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "party")
@NoArgsConstructor
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(nullable = false, name = "user_id")
    private Long userId;

    @Column(nullable = false, name = "restaurant_name")
    private String restaurantName;

    @Column(nullable = false, name = "restaurant_location")
    private String restaurantLocation;

    @Column(nullable = false, name = "recruitment_limit")
    private Integer recruitmentLimit;

    private String detail;
}
