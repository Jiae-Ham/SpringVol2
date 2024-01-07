package com.example.BCSD.repository;

import com.example.BCSD.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByLoginId(String loginId);
    Optional<User> findByLoginId(String loginId);
}
