package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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

    @Column (name = "km_rodados")
    private Integer kmRodados;

    @Column (name = "adicional_km_rodado")
    private BigDecimal adicionalKmRodado;

}
