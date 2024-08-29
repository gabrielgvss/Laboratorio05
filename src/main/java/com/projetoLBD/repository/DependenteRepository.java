package com.projetoLBD.repository;

import com.projetoLBD.entity.Dependente;
import jakarta.persistence.EntityManager;
import java.util.List;

public class DependenteRepository {
    private final EntityManager em;
    private final DAOGenerico<Dependente> daoGenerico;

    public DependenteRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    // Busca um Dependente pelo ID
    public Dependente buscarPorID(Integer id) {
        return daoGenerico.buscarPorID(Dependente.class, id);
    }

    // Método para listar todos os Dependentes
    public List<Object[]> listarDependentes() {
        String jpql = "SELECT d FROM Dependente d";
        return daoGenerico.consultar(jpql, Dependente.class);
    }

    // Lista todos os Dependentes associados a um determinado Funcionário
    public List<Object[]> listarPorIdFuncionario(Integer id) {
        String jpql = "SELECT d FROM Dependente d WHERE d.funcionario.id = :id";
        return daoGenerico.consultar(jpql, Dependente.class, "id", id);
    }

    // Busca Dependentes por nome
    public List<Object[]> buscarPorNome(String nome) {
        String jpql = "SELECT d FROM Dependente d WHERE UPPER(d.nome) LIKE :nome";
        return daoGenerico.consultar(jpql, Dependente.class, "nome", nome.toUpperCase() + "%");
    }

    // Insere ou altera um registro de Dependente no banco de dados
    public Dependente salvarOuAtualizar(Dependente dependente) {
        return daoGenerico.salvaOuAtualiza(dependente);
    }

    // Exclui um Dependente
    public void excluir(Dependente dependente) {
        daoGenerico.excluir(dependente);
    }
}
