package com.wintech.wtuser.repositories;

import com.wintech.wtuser.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);
    Optional<User> findByEmailOrLogin(String email, String login);

}
