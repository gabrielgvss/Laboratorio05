package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor @NoArgsConstructor
@Table (name="distancia")
@Entity
public @Data class Distancia implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cidade_origem")
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "id_cidade_destino")
    private Cidade cidadeDestino;

    @Column
    private Integer quilometros;

}
