package com.wintech.wtclientservice.domains.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeRegister {

    CLIENTE("Cliente"),
    FORNECEDOR("Fornecedor"),
    VENDEDOR("Vendedor"),
    INSTALADOR("Instalador");

    public String description;

}
