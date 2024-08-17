package com.projetoLBD.repository;

import com.projetoLBD.entity.EntidadeBase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

public class DAOGenerico<T extends EntidadeBase> {
    private final EntityManager em;

    // Construtor que recebe o EntityManager
    public DAOGenerico(EntityManager manager) {
        this.em = manager;
    }

    // Busca uma entidade pelo seu ID
    public T buscarPorID(Class<T> clazz, Integer id) {
        return em.find(clazz, id);
    }


    // Salva ou atualiza uma entidade
    public T salvaOuAtualiza(T t) {
        // Inicia uma transação
        em.getTransaction().begin();
        try {
            if (Objects.isNull(t.getId())) {
                // Se a entidade não tem ID, é uma nova entidade (inserção)
                em.persist(t);
            } else {
                // Se a entidade tem ID, é uma entidade existente (atualização)
                t = em.merge(t);
            }
            // Confirma as alterações na transação
            em.getTransaction().commit();
        } catch (Exception e) {
            // Reverte as alterações em caso de erro
            em.getTransaction().rollback();
            throw e; // Lança a exceção para ser tratada em outro lugar
        }
        return t;
    }

    // Exclui uma entidade
    public void excluir(T t) {
        // Remove a entidade do contexto de persistência
        em.remove(t);
        // Força a sincronização com o banco de dados
        em.flush();
    }

    // Executa uma consulta JPQL com parâmetros
    public List<T> consultar(String jpql, Class<T> clazz, Object... params) {
        TypedQuery<T> query = em.createQuery(jpql, clazz);

        // Define os parâmetros da consulta
        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        // Retorna a lista de resultados
        return query.getResultList();
    }
}
