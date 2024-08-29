package com.projetoLBD.repository;

import com.projetoLBD.entity.Distancia;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DistanciaRepository {
    private EntityManager em;
    private final DAOGenerico<Distancia> daoGenerico;

    public DistanciaRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    // Busca uma Distancia pelo ID
    public Distancia buscarPorID(Integer id) {
        return daoGenerico.buscarPorID(Distancia.class, id);
    }

    // Lista todas as Distancias
    public List<Object[]> listarDistancias() {
        // JPQL para listar todas as distâncias
        String jpql = "SELECT d FROM Distancia d";
        return daoGenerico.consultar(jpql, Distancia.class);
    }

    // Busca distâncias por cidades de origem e destino
    public List<Object[]> buscarPorCidades(Integer idCidadeOrigem, Integer idCidadeDestino) {
        // JPQL para buscar distâncias com base nas cidades de origem e destino
        String jpql = "SELECT d FROM Distancia d " +
                "WHERE d.cidadeOrigem.id = :idCidadeOrigem " +
                "AND d.cidadeDestino.id = :idCidadeDestino";

        return daoGenerico.consultar(jpql, Distancia.class, "idCidadeOrigem", idCidadeOrigem, "idCidadeDestino", idCidadeDestino);
    }

    // Salva ou atualiza uma Distancia
    public Distancia salvarOuAtualizar(Distancia distancia) {
        return daoGenerico.salvaOuAtualiza(distancia);
    }

    // Exclui uma Distancia
    public void excluir(Distancia distancia) {
        daoGenerico.excluir(distancia);
    }
}
