package com.wintech.wtpessoasservice.repositories;

import com.fernandoangeli.win.domains.companyOrPerson.address.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository <City, Long> {
}
