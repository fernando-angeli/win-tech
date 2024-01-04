package com.wintech.wtpessoasservice.repositories;

import com.fernandoangeli.win.domains.companyOrPerson.CompanyOrPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyOrPersonRepository extends JpaRepository <CompanyOrPerson, Long> {
}
