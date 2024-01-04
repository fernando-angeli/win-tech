package com.fernandoangeli.win.domains.enums;

import lombok.*;

@Getter
@AllArgsConstructor
public enum Lado {

    ESQUERDA("esquerda"),
    DIREITA("direita"),
    AMBIDESTRA("ambidestra");

    private String descricao;

}
