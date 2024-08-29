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
    public List<Object[]> listarClientes() {
        String jpql = "SELECT pf, c FROM PessoaFisica pf JOIN Cliente c ON pf.id = c.id";
        return daoGenerico.consultar(jpql);
    }

    // Método para buscar clientes por nome
    public List<Object[]> buscarPorNome(String nome) {
        String jpql = "SELECT pf, c FROM PessoaFisica pf JOIN Cliente c ON pf.id = c.id WHERE UPPER(pf.nome) LIKE :nome";
        return daoGenerico.consultar(jpql, "nome", nome.toUpperCase() + "%");
    }

    // Salva ou atualiza um cliente
    public Cliente salvarOuAtualizar(Cliente cliente) {
        return daoGenerico.salvaOuAtualiza(cliente);
    }

    // Exclui um cliente
    public void excluir(Cliente cliente) {
        daoGenerico.excluir(cliente);
    }
}

