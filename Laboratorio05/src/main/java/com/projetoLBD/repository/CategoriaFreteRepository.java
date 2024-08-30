package com.projetoLBD.repository;

import com.projetoLBD.entity.CategoriaFrete;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CategoriaFreteRepository {
    private final EntityManager em;
    private final DAOGenerico<CategoriaFrete> daoGenerico;

    public CategoriaFreteRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    // Busca uma CategoriaFrete pelo ID
    public CategoriaFrete buscarPorID(Integer id) {
        return daoGenerico.buscarPorID(CategoriaFrete.class, id);
    }

    // Método para listar todas as Categorias de Frete
    public List<Object[]> listarCategoriaFretes() {
        String jpql = "SELECT cf FROM CategoriaFrete cf";
        return daoGenerico.consultar(jpql, CategoriaFrete.class);
    }

    // Lista todas as Categorias de Frete associadas a um determinado Frete
    public List<Object[]> listarCategoriasPorIdFrete(Integer id) {
        String jpql = "SELECT cf FROM CategoriaFrete cf WHERE cf.frete.id = :id";
        return daoGenerico.consultar(jpql, CategoriaFrete.class, "id", id);
    }

    // Busca Categorias de Frete por descrição
    public List<Object[]> buscarPorDescricao(String descricao) {
        String jpql = "SELECT cf FROM CategoriaFrete cf WHERE UPPER(cf.descricao) LIKE :descricao";
        return daoGenerico.consultar(jpql, CategoriaFrete.class, "descricao", descricao.toUpperCase() + "%");
    }

    // Salva ou altera uma CategoriaFrete
    public CategoriaFrete salvarOuAlterar(CategoriaFrete categoriaFrete) {
        return daoGenerico.salvaOuAtualiza(categoriaFrete);
    }

    // Exclui uma CategoriaFrete
    public void excluir(CategoriaFrete categoriaFrete) {
        daoGenerico.excluir(categoriaFrete);
    }
}
