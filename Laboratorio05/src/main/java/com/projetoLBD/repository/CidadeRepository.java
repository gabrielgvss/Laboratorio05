package com.projetoLBD.repository;

import com.projetoLBD.entity.Cidade;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CidadeRepository {
    private EntityManager em;
    private final DAOGenerico<Cidade> daoGenerico;

    public CidadeRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);

    }

    // Busca um funcionário pelo ID
    public Cidade buscarPorID(Integer id) {
        return daoGenerico.buscarPorID(Cidade.class, id);

    }


    // Método para listar todos os Cidades com atributos combinados
    public List listarCidades() {
        // JPQL para selecionar atributos combinados de PessoaFisica e Cidade
        String jpql = "SELECT c FROM cidade c";

        return daoGenerico.consultar(jpql, Cidade.class);

    }

    public List<Object[]> buscarPorNome(String nome) {
        // JPQL para selecionar os atributos de PessoaFisica e Cidade
        String jpql = "SELECT c FROM cidade c " +
                "WHERE UPPER(c.nome) LIKE :nome";

        return daoGenerico.consultar(jpql, Cidade.class, "nome", nome.toUpperCase() + "%");

    }

    // Salva ou atualiza um Cidade
    public Cidade salvarOuAtualizar(Cidade cidade) {
        return daoGenerico.salvaOuAtualiza(cidade);

    }

    // Exclui um Cidade
    public void excluir(Cidade cidade) {
        daoGenerico.excluir(cidade);

    }
}
