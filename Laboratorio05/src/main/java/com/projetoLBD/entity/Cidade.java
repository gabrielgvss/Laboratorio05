package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Table (name="cidade")
@Entity
public @Data class Cidade implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String uf;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String estado;

    @OneToMany (mappedBy = "cidadeOrigem")
    private Set<Frete> fretesOrigem = new HashSet<>();

    @OneToMany (mappedBy = "cidadeDestino")
    private Set<Frete> fretesDestino = new HashSet<>();

    @OneToMany(mappedBy = "cidadeOrigem")
    private Set<Distancia> distanciasDeOrigem = new HashSet<>();

    @OneToMany(mappedBy = "cidadeDestino")
    private Set<Distancia> distanciasDeDestino = new HashSet<>();

}
