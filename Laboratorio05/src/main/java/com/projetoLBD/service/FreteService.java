package com.projetoLBD.service;

import com.projetoLBD.entity.CategoriaFrete;
import com.projetoLBD.entity.Distancia;
import com.projetoLBD.entity.Frete;
import com.projetoLBD.repository.DistanciaRepository;
import com.projetoLBD.repository.FreteRepository;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class FreteService {

    private final FreteRepository freteRepository;

    public FreteService(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    // Busca um Frete pelo código
    public Frete buscarPorCodigo(Integer codigo) {
        Frete frete = freteRepository.buscarPorCodigo(codigo);
        if (frete == null) {
            throw new EntityNotFoundException("Frete com código " + codigo + " não encontrado.");

        }
        return frete;

    }

    // Cadastrar frete
    public Frete cadastrarFrete(Frete frete) {
        validarFrete(frete);
        return freteRepository.salvarOuAtualizar(frete);

    }

    // Exclui um Frete
    public void excluir(Integer codigo) {
        Frete frete = buscarPorCodigo(codigo);
        freteRepository.excluir(frete);

    }

    // Calcula o valor do frete
    public BigDecimal calcularFrete(Integer codigo) {
        Frete frete = buscarPorCodigo(codigo);
        return frete.calcularFrete();

    }

    // Lista todos os Fretes
    public List<Object[]> listarFretes() {
        List<Object[]> listaFretes = freteRepository.listarFretes();
        if (listaFretes.isEmpty()) {
            throw new EntityNotFoundException("Nenhum frete encontrado.");

        }
        return listaFretes;

    }

    // Lista todos os Fretes associados a um determinado Cliente
    public List<Object[]> listarPorCliente(Integer idCliente) {
        List<Object[]> fretes = freteRepository.listarPorCliente(idCliente);
        if (fretes.isEmpty()) {
            throw new EntityNotFoundException("Nenhum frete encontrado para o cliente com ID " + idCliente);

        }
        return fretes;
    }

    public Double calcularValorFrete(Frete frete) {
        try {
            if (frete == null || frete.getCidadeOrigem() == null || frete.getCidadeDestino() == null) {
                throw new IllegalArgumentException("Frete ou cidades de origem e destino não podem ser nulos.");
            }

            DistanciaRepository distanciaRepository = new DistanciaRepository();
            Distancia distanciaAB = distanciaRepository.distanciaEntreAB(frete.getCidadeOrigem(), frete.getCidadeDestino());

            if (distanciaAB == null) {
                throw new RuntimeException("Distância entre " + frete.getCidadeOrigem() + " e " + frete.getCidadeDestino() + " não encontrada.");
            }

            CategoriaFrete categoriaFrete = frete.getCategoriaFrete();
            double percentualAdicional = categoriaFrete.getPercentualAdicional();
            double valorSemAdicional = frete.getValorKmRodado().doubleValue() * distanciaAB.getQuilometros();
            if (percentualAdicional == 0) {
                return valorSemAdicional;
            }

            return valorSemAdicional + (valorSemAdicional * (percentualAdicional / 100.0));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao calcular o valor do frete: " + e.getMessage(), e);
        }
    }

    // Valida os dados do Frete
    private void validarFrete(Frete frete) {
        if (frete.getCategoriaFrete() == null) {
            throw new IllegalArgumentException("Categoria de frete não pode ser nula.");
        }
        if (frete.getCidadeOrigem() == null || frete.getCidadeDestino() == null) {
            throw new IllegalArgumentException("Cidades de origem e destino não podem ser nulas.");
        }
        if (frete.getValorKmRodado() == null || frete.getValorKmRodado().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor por quilômetro rodado deve ser maior que zero.");
        }
    }
}
