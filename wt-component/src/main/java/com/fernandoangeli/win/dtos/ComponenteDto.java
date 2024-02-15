package com.fernandoangeli.win.dtos;

import com.fernandoangeli.win.domains.enums.UnidadeDeMedida;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ComponenteDto {

    private Long id;
    private Integer codigo;
    private String codigoFornecedor;
    private String descricao;
    private TipoComponenteDto tipoComponente;
    private GrupoComponenteDto grupoComponente;
    private SubgrupoComponenteDto subgrupoComponente;
    private List<Long> fornecedoresId = new ArrayList<>();
    private AcabamentoComponenteDto acabamento;
    private UnidadeDeMedida unit;
    private Double preco;
    private Double peso;
    private Double pedidoMinimo;
    private Double estoque;
    private Double reservaEstoque;

}
