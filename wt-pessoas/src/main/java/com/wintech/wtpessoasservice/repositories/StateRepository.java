package com.wintech.wtpessoasservice.repositories;

import com.fernandoangeli.win.domains.companyOrPerson.address.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository <State, Long> {
}
