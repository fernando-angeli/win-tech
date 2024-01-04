package com.wintech.wtpessoasservice.dtos;

import com.fernandoangeli.win.domains.companyOrPerson.address.Address;
import com.fernandoangeli.win.domains.companyOrPerson.enums.TypeCompanyOrPerson;
import com.fernandoangeli.win.domains.companyOrPerson.enums.TypeRegister;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyOrPersonDto {

    private TypeCompanyOrPerson companyOrPerson;
    private List<TypeRegister> type = new ArrayList<>();
    private String name;
    private String telephone1;
    private String telephone2;
    private String email;
    private String cpfOrCnpj;
    private String rgOrIe;
    private Address address;
    private Address deliveryAddress;

}
