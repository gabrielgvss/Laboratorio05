package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Table (name = "dependente")
@Entity
public @Data class Dependente implements EntidadeBase {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @ManyToOne @JoinColumn(name="id_funcionario")
   private Funcionario funcionario;

   @Column (nullable = false)
   private String nome;

   @Column (name = "data_nascimento", nullable = false)
   private LocalDate dataNascimento;


}
