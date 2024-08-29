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
        try {
            if (Objects.isNull(t.getId())) {
                em.persist(t);
            } else {
                t = em.merge(t);
            }
        } catch (Exception e) {
            throw e;
        }
        return t;
    }

    // Exclui uma entidade
    public void excluir(T t) {
        em.remove(t);
        em.flush();
    }

    // Executa uma consulta JPQL com parâmetros e retorna uma lista de objetos genéricos
    public List<Object[]> consultar(String jpql, Object... params) {
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        return query.getResultList();
    }
}
