package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Table (name="filial")
@Entity
public @Data class Filial implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column
    private String contato;

    @Column(length = 15, nullable = false)
    private String telefone;

    @OneToMany (mappedBy = "filial")
    private Set<Funcionario> funcionarios = new HashSet<>();

    @OneToMany (mappedBy = "filial")
    private Set<Veiculo> veiculos = new HashSet<>();

}
