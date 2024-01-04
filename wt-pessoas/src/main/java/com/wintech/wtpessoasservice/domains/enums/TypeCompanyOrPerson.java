package com.wintech.wtpessoasservice.domains.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeCompanyOrPerson {

    FISICA("Fisica"),
    JURIDICA("Juridica");

    private String description;
}
