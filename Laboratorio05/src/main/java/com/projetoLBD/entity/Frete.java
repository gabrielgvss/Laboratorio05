package com.projetoLBD.entity;

import com.projetoLBD.repository.DistanciaRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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

    @ManyToOne @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @Column(name = "numero_nota_fiscal")
    private Integer numeroNotaFiscal;

    @Column (name = "valor_km_rodado")
    private BigDecimal valorKmRodado;

    @OneToMany(mappedBy = "frete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemFrete> itemFretes;

    @Override
    public Integer getId() {
        return this.codigo;

    }

    public BigDecimal calcularFrete() {
        // Obtém a distância entre a cidade de origem e destino
        DistanciaRepository distanciarepo = new DistanciaRepository();
        Integer distancia = distanciarepo.distanciaEntreAB(this.getCidadeOrigem(), this.getCidadeDestino()).getQuilometros();

        System.out.println(distancia);

        // Se a distância não for encontrada, retornar BigDecimal.ZERO
        if (distancia == 0) {
            return BigDecimal.ZERO;
        }

        // Obtendo o percentual adicional da categoria de frete
        BigDecimal percentualAdicional = BigDecimal.valueOf(this.getCategoriaFrete().getPercentualAdicional());

        // Calculando o valor original do frete
        BigDecimal valorKmRodado = this.getValorKmRodado();
        BigDecimal valorOriginal = BigDecimal.valueOf(distancia).multiply(valorKmRodado);

        // Calculando o acréscimo percentual
        BigDecimal percentual = percentualAdicional.divide(BigDecimal.valueOf(100), BigDecimal.ROUND_HALF_UP);
        BigDecimal valorAcrecimo = valorOriginal.multiply(percentual);

        // Retornando o valor original mais o acréscimo
        return valorOriginal.add(valorAcrecimo);
    }


    private Integer buscaDistancia(Cidade origem, Cidade destino) {
        // Navega pelas distâncias de origem e procura a distância para o destino
        for (Distancia distancia : origem.getDistanciasDeOrigem()) {
            if (distancia.getCidadeDestino().equals(destino)) {
                // Retorna a distância em quilômetros
                System.out.println(distancia.getQuilometros());
                return distancia.getQuilometros();
            }
        }

        // Se não encontrar a distância, retorna 0 em vez de null
        return 0;  // Ou outra abordagem adequada para sua lógica
    }

    @Override
    public String toString() {
        return "Frete{" +
                "codigo=" + codigo +
                ", categoriaFrete=" + (categoriaFrete != null ? categoriaFrete.getDescricao() : "null") +
                ", cidadeOrigem=" + (cidadeOrigem != null ? cidadeOrigem.getNome() : "null") +
                ", cidadeDestino=" + (cidadeDestino != null ? cidadeDestino.getNome() : "null") +
                ", veiculo=" + (veiculo != null ? veiculo.getTipoVeiculo() : "null") +
                ", cliente=" + (cliente != null ? cliente.getNome() : "null") +
                ", funcionario=" + (funcionario != null ? funcionario.getNome() : "null") +
                ", numeroNotaFiscal=" + numeroNotaFiscal +
                ", valorKmRodado=" + valorKmRodado +
                ", itemFretes=" + (itemFretes != null ? itemFretes.size() + " items" : "null") +
                '}';
    }


}
