package com.mbj.doeat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "party")
@NoArgsConstructor
@AllArgsConstructor
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(nullable = false, name = "restaurant_name")
    private String restaurantName;

    @Column(nullable = false, name = "restaurant_location")
    private String restaurantLocation;

    @Column(nullable = false, name = "recruitment_limit")
    private Integer recruitmentLimit;

    @Column(nullable = false, name = "current_number_people")
    private Integer currentNumberPeople;

    @Column(nullable = false, name = "restaurant_category")
    private String restaurantCategory;

    @Column(nullable = false, name = "restaurant_link")
    private String restaurantLink;

    private String detail;
}
