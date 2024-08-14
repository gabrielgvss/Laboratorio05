package com.projetoLBD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Table (name = "frete")
@Entity
public @Data class Frete implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @ManyToOne @JoinColumn (name = "id_categoria_frete")
    private CategoriaFrete categoriaFrete;

    @ManyToOne @JoinColumn (name = "id_cidade_origem")
    private Cidade cidadeOrigem;

    @ManyToOne @JoinColumn (name = "id_cidade_destino")
    private Cidade cidadeDestino;

    @ManyToOne @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @ManyToOne @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "numero_nota_fiscal")
    private Integer numeroNotaFiscal;

    @Column (name = "valor_km_rodado")
    private BigDecimal valorKmRodado;

    @OneToMany(mappedBy = "frete", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemFrete> itensFrete = new HashSet<>();

    @Override
    public Integer getId() {
        return this.codigo;

    }

    // Calculado através das distâncias entre as cidades e categoria do frete
    public BigDecimal calcularFrete() {
        return BigDecimal.valueOf(0); //TEMPORARIO ENQUANTO AINDA NAO SE FINALIZA A MODELAGEM

    }

}
