package com.mbj.doeat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, name = "kakao_user_id")
    private String kakaoUserId;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, name = "image_url")
    private String imageUrl;
}
