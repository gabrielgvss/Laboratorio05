package com.projetoLBD.repository;

import com.projetoLBD.entity.Frete;
import jakarta.persistence.EntityManager;
import java.util.List;

public class FreteRepository {
    private final EntityManager em;
    private final DAOGenerico<Frete> daoGenerico;

    public FreteRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);

    }

    // Busca um Frete pelo código
    public Frete buscarPorCodigo(Integer codigo) {
        return daoGenerico.buscarPorID(Frete.class, codigo);

    }

    // Método para listar todos os Fretes
    public List<Object[]> listarFretes() {
        String jpql = "SELECT f FROM Frete f";
        return daoGenerico.consultar(jpql, Frete.class);

    }

    // Lista todos os Fretes associados a um determinado Cliente
    public List<Object[]> listarPorCliente(Integer idCliente) {
        String jpql = "SELECT f FROM Frete f WHERE f.cliente.id = :idCliente";
        return daoGenerico.consultar(jpql, Frete.class, "idCliente", idCliente);

    }

    // Lista todos os Fretes associados a um determinado Veículo
    public List<Object[]> listarPorVeiculo(Integer idVeiculo) {
        String jpql = "SELECT f FROM Frete f WHERE f.veiculo.id = :idVeiculo";
        return daoGenerico.consultar(jpql, Frete.class, "idVeiculo", idVeiculo);

    }

    // Lista todos os Fretes associados a um determinado Funcionário
    public List<Object[]> listarPorFuncionario(Integer idFuncionario) {
        String jpql = "SELECT f FROM Frete f WHERE f.funcionario.id = :idFuncionario";
        return daoGenerico.consultar(jpql, Frete.class, "idFuncionario", idFuncionario);

    }

    // Lista todos os Fretes associados a um determinado ItemFrete
    public List<Object[]> listarPorItemFrete(Integer idItemFrete) {
        String jpql = "SELECT f FROM Frete f JOIN f.itemFretes i WHERE i.id = :idItemFrete";
        return daoGenerico.consultar(jpql, Frete.class, "idItemFrete", idItemFrete);

    }

    // Lista todos os Fretes associados a uma determinada CategoriaFrete
    public List<Object[]> listarPorCategoriaFrete(Integer idCategoriaFrete) {
        String jpql = "SELECT f FROM Frete f WHERE f.categoriaFrete.id = :idCategoriaFrete";
        return daoGenerico.consultar(jpql, Frete.class, "idCategoriaFrete", idCategoriaFrete);

    }

    // Insere ou altera um registro de Frete no banco de dados
    public Frete salvarOuAtualizar(Frete frete) {
        return daoGenerico.salvaOuAtualiza(frete);
    }

    // Exclui um Frete
    public void excluir(Frete frete) {
        daoGenerico.excluir(frete);
    }
}
