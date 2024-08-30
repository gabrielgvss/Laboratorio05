package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Table (name = "categoria_frete")
@Entity
public @Data class CategoriaFrete implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column (name = "percentual_adicional")
    private float percentualAdicional;

    @OneToMany(mappedBy = "categoriaFrete", cascade = CascadeType.ALL)
    private Set<Frete> fretes = new HashSet<>();

}
