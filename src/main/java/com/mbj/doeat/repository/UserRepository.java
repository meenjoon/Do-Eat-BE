package com.mbj.doeat.repository;

import com.mbj.doeat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByKakaoUserId(Long kakaoUserId);
}
