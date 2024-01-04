package com.wintech.wtpessoasservice.dtos;

import com.fernandoangeli.win.domains.companyOrPerson.address.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

    private String city;
    private State state;

}
