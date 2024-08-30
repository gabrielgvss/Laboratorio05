package com.projetoLBD.repository;

import com.projetoLBD.entity.Filial;
import jakarta.persistence.EntityManager;


import java.util.List;

public class FilialRepository {
    private EntityManager em;
    private final DAOGenerico<Filial> daoGenerico;

    public FilialRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);

    }

    // Busca um Filial pelo ID
    public Filial buscarPorID(Integer id) {
        return daoGenerico.buscarPorID(Filial.class, id);

    }

    // Método para listar todas as Filiais com atributos combinados
    public List<Object[]> listarFilials() {
        String jpql = "SELECT f FROM Filial f ";

        return daoGenerico.consultar(jpql, Filial.class);

    }

    public List<Object[]> buscarPorNome(String nome) {
        // JPQL para selecionar os atributos de PessoaFisica e Filial
        String jpql = "SELECT f FROM Filial f " +
                      "WHERE UPPER(f.nome) LIKE :nome";

        return daoGenerico.consultar(jpql, Filial.class, "nome", nome.toUpperCase() + "%");
    }

    // Salva ou atualiza um registro de filial no banco de dados
    public void salvarOuAtualizar(Filial filial) {
        daoGenerico.salvaOuAtualiza(filial);

    }

    // Exclui uma Filial
    public void excluir(Filial filial) {
        daoGenerico.excluir(filial);

    }
}
