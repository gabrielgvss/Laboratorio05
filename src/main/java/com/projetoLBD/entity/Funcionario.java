package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "funcionario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario extends PessoaFisica {
    @Column(length = 20, nullable = false)
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Dependente> dependentes = new HashSet<>();

    @OneToMany(mappedBy = "funcionario")
    private Set<Frete> fretes =  new HashSet<>();

}
