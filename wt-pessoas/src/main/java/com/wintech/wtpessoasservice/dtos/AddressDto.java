package com.wintech.wtpessoasservice.dtos;

import com.fernandoangeli.win.domains.companyOrPerson.address.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String street;
    private Integer number;
    private String district;
    private String zipCode;
    private City city;

}
