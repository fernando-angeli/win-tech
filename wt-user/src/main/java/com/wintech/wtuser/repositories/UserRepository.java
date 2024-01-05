package com.wintech.wtuser.repositories;

import com.wintech.wtuser.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

}
