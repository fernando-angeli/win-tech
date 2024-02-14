package com.wintech.wtclientservice.repositories;

import com.wintech.wtclientservice.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long> {
}
