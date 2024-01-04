package com.fernandoangeli.win.domains.enums;

import lombok.*;

@Getter
@AllArgsConstructor
public enum UnidadeDeMedida {

    UNIDADE("unidade"),
    PAR("par"),
    BARRA("barra"),
    METRO_LINEAR("metro linear"),
    METRO_QUADRADO("metro quadrado");

    private String descricao;

}
