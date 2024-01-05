package com.wintech.wtuser.repositories;

import com.wintech.wtuser.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {

}
