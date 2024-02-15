package com.fernandoangeli.win.domains.opcionais;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupoComponente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<SubgrupoComponente> subgrupoComponentes = new HashSet<>();

}
