package com.fernandoangeli.win.domains;

import com.fernandoangeli.win.domains.enums.UnidadeDeMedida;
import com.fernandoangeli.win.domains.opcionais.GrupoComponente;
import com.fernandoangeli.win.domains.opcionais.SubgrupoComponente;
import com.fernandoangeli.win.domains.opcionais.TipoComponente;
import com.fernandoangeli.win.domains.opcionais.AcabamentoComponente;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@RequiredArgsConstructor
@SequenceGenerator(name = "seq_component", initialValue = 2, allocationSize = 1)
public abstract class Componente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_component")
    private Long id;

    private Integer codigo;
    private String codigoFornecedor;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tipo_componente_id")
    private TipoComponente tipoComponente;

    @ManyToOne
    @JoinColumn(name = "grupo_componente_id")
    private GrupoComponente grupoComponente;

    @ManyToOne
    @JoinColumn(name = "subgrupo_componente_id")
    private SubgrupoComponente subgrupoComponente;

    Set<Long> fornecedoresId = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "acabamento_componente_id")
    private AcabamentoComponente acabamentoComponente;

    @Enumerated(EnumType.STRING)
    private UnidadeDeMedida unidadeDeMedida;
    private Double preco;
    private Double peso;
    private Double pedidoMinimo;
    private Double estoque;
    private Double reservaDeEstoque;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Componente componente = (Componente) o;
        return getId() != null && Objects.equals(getId(), componente.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
