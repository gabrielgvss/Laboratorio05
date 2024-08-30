package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Table (name = "item_frete")
@Entity
public @Data class ItemFrete implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn(name = "id_frete")
    private Frete frete;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private float peso;

}
