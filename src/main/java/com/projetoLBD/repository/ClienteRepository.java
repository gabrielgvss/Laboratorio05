package com.projetoLBD.repository;

import com.projetoLBD.entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteRepository {
    private EntityManager em;
    private final DAOGenerico<Cliente> daoGenerico;

    public ClienteRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);

    }

    // Busca um cliente pelo ID
    public Cliente buscarPorID(Integer id) {
        return daoGenerico.buscarPorID(Cliente.class, id);

    }

    // Método para listar todos os clientes com atributos combinados
    public List<Cliente> listarClientes() {
        String jpql = "SELECT pf, c " +
                "FROM PessoaFisica pf " +
                "JOIN Cliente c ON pf.id = c.id";

        return daoGenerico.consultar(jpql, Cliente.class);
    }


    // Método para buscar clientes por nome
    public List<Cliente> buscarPorNome(String nome) {
        // Defina a consulta JPQL
        String jpql = "SELECT pf, c " +
                "FROM PessoaFisica pf " +
                "JOIN Cliente c ON pf.id = c.id " +
                "WHERE UPPER(pf.nome) LIKE :nome";

        // Chama o método consultar do DAOGenerico
        return daoGenerico.consultar(jpql, Cliente.class, "nome", nome.toUpperCase() + "%");
    }

    // Salva ou atualiza um cliente
    public Cliente salvaOuAtualiza(Cliente cliente) {
        return daoGenerico.salvaOuAtualiza(cliente);

    }

    // Exclui um cliente
    public void excluir(Cliente cliente) {
        daoGenerico.excluir(cliente);

    }
}
