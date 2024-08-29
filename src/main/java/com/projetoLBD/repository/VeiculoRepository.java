package com.projetoLBD.repository;

import com.projetoLBD.entity.Veiculo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VeiculoRepository {
    private EntityManager em;
    private final DAOGenerico<Veiculo> daoGenerico;

    public VeiculoRepository(EntityManager manager) {
        this.em = manager;
        this.daoGenerico = new DAOGenerico<>(manager);

    }

    // Busca um Veiculo pelo ID
    public Veiculo buscarPorID(Integer id) {
        return daoGenerico.buscarPorID(Veiculo.class, id);

    }


    // Método para listar Veiculos
    public List<Object[]> listarVeiculos() {
        // JPQL para selecionar atributos combinados de PessoaFisica e Veiculo
        String jpql = "SELECT v, tv " +
                "FROM Veiculo v " +
                "JOIN v.tipoVeiculo tv";

        return daoGenerico.consultar(jpql, Veiculo.class);
    }

    // Salva ou atualiza uma Veiculo
    public Veiculo salvaOuAtualiza(Veiculo Veiculo) {
        return daoGenerico.salvaOuAtualiza(Veiculo);

    }

    // Exclui um Veiculo
    public void excluir(Veiculo Veiculo) {
        daoGenerico.excluir(Veiculo);

    }
}
