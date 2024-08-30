package com.projetoLBD.repository;

import com.projetoLBD.entity.ItemFrete;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ItemFreteRepository {
    private final EntityManager em;
    private final DAOGenerico<ItemFrete> daoGenerico;

    public ItemFreteRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    // Busca um ItemFrete pelo ID
    public ItemFrete buscarPorID(Integer id) {
        return daoGenerico.buscarPorID(ItemFrete.class, id);
    }

    // Método para listar todos os ItemFretes
    public List<Object[]> listarItemFretes() {
        String jpql = "SELECT i FROM ItemFrete i";
        return daoGenerico.consultar(jpql, ItemFrete.class);
    }

    // Lista todos os ItemFretes associados a um determinado Frete
    public List<Object[]> listarPorIdFrete(Integer id) {
        String jpql = "SELECT i FROM ItemFrete i WHERE i.frete.id = :id";
        return daoGenerico.consultar(jpql, ItemFrete.class, "id", id);
    }

    // Busca ItemFretes por descrição
    public List<Object[]> buscarPorDescricao(String descricao) {
        String jpql = "SELECT i FROM ItemFrete i WHERE UPPER(i.descricao) LIKE :descricao";
        return daoGenerico.consultar(jpql, ItemFrete.class, "descricao", descricao.toUpperCase() + "%");
    }

    // Insere ou altera um registro de ItemFrete no banco de dados
    public ItemFrete salvarOuAtualizar(ItemFrete itemFrete) {
        return daoGenerico.salvaOuAtualiza(itemFrete);
    }

    // Exclui um ItemFrete
    public void excluir(ItemFrete itemFrete) {
        daoGenerico.excluir(itemFrete);
    }
}
