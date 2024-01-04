package com.fernandoangeli.win.domains;

import com.fernandoangeli.win.domains.enums.Lado;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ferragem extends Componente {

    private Integer entrada;
    private Integer largura;
    private Integer altura;
    private Integer comprimento;
    private Integer quantidadePontos;
    @Enumerated(EnumType.STRING)
    private Lado lado;

}
