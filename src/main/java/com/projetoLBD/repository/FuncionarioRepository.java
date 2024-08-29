package com.projetoLBD.repository;

import com.projetoLBD.entity.Funcionario;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FuncionarioRepository {
    private EntityManager em;
    private final DAOGenerico<Funcionario> daoGenerico;

    public FuncionarioRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);

    }

    // Busca um funcionário pelo ID
    public Funcionario buscarPorID(Integer id) {
        return daoGenerico.buscarPorID(Funcionario.class, id);

    }


    // Método para listar todos os Funcionarios com atributos combinados
    public List listarFuncionarios() {
        // JPQL para selecionar atributos combinados de PessoaFisica e Funcionario
        String jpql = "SELECT pf, f " +
                "FROM PessoaFisica pf " +
                "JOIN Funcionario f ON pf.id = f.id " +
                "JOIN Filial fl ON f.filial.id = fl.id";

        return daoGenerico.consultar(jpql, Funcionario.class);

    }

    public List<Object[]> buscarPorNome(String nome) {
        // JPQL para selecionar os atributos de PessoaFisica e Funcionario
        String jpql = "SELECT pf, f " +
                "FROM PessoaFisica pf " +
                "JOIN Funcionario f ON pf.id = f.id " +
                "JOIN Filial fl ON f.filial.id = fl.id " +
                "WHERE UPPER(pf.nome) LIKE :nome";

        return daoGenerico.consultar(jpql, Funcionario.class, "nome", nome.toUpperCase() + "%");

    }

    // Salva ou atualiza um Funcionario
    public Funcionario salvarOuAtualizar(Funcionario funcionario) {
        return daoGenerico.salvaOuAtualiza(funcionario);

    }

    // Exclui um Funcionario
    public void excluir(Funcionario funcionario) {
        daoGenerico.excluir(funcionario);

    }
}
