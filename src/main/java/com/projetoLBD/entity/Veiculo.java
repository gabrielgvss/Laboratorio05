package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Table(name = "veiculo")
@Entity
public @Data class Veiculo implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn(name = "id_filial")
    private Filial filial;

    @ManyToOne @JoinColumn(name = "id_tipo_veiculo")
    private TipoVeiculo tipoVeiculo;

    @Column (nullable = false)
    private String placa;

    @OneToMany(mappedBy = "veiculo")
    private Set<Frete> fretes = new HashSet<>();

}
