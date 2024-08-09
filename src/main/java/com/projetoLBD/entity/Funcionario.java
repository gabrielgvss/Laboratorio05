package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor  @NoArgsConstructor
@Table (name = "funcionario")
@Entity
public @Data class Funcionario extends PessoaFisica {
    @ManyToOne @JoinColumn(name="id_filial")
    private Filial filial;

    @Column (nullable = false)
    private String matricula;

    @OneToMany (mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Dependente> dependentes = new HashSet<>();

}
