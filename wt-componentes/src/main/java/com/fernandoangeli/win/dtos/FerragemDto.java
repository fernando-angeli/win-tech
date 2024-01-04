package com.fernandoangeli.win.dtos;

import com.fernandoangeli.win.domains.enums.Lado;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FerragemDto extends ComponenteDto {

    private Integer entrada;
    private Integer largura;
    private Integer altura;
    private Integer comprimento;
    private Integer quantidadePontos;
    private Lado lado;

}
