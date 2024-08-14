package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table (name = "pessoa_fisica")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public @Data abstract class PessoaFisica implements EntidadeBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column
    private String email;

    @Column
    private String telefone;

}
