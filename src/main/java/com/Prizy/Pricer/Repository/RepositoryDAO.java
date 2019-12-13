
package com.Prizy.Pricer.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class RepositoryDAO {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Saves the Hibernate Entity.
	 *
	 * @param entity The entity to persist
	 */
	public void save(Object entity) {
		entityManager.persist(entity);
	}

	/**
	 * Delete / Remove the Hibernate Entity instance.
	 *
	 * @param entity The entity instance to remove
	 */
	public void delete(Object entity) {
		entityManager.remove(entity);
	}

	/**
	 * ****** HQL Related - start *******
	 */
	/**
	 * Executes the provided HQL query
	 *
	 * @param hql The query to execute
	 * @return List
	 */
	public List executeQuery(String hql) {
		return executeQueryPaging(hql, null, null);
	}

	/**
	 * Executes the provided HQL query after applying the provided parameters and
	 * paging parameters and returns the result
	 *
	 * @param hql         The query to execute
	 * @param params      Query Parameters
	 * @param pagingParam paging parameters
	 * @return List
	 */
	public List executeQueryPaging(String hql, Object[] params, Integer[] pagingParam) {
		Query query = entityManager.createQuery(hql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}
		if (pagingParam != null) {
			query.setFirstResult(pagingParam[0]);
			query.setMaxResults(pagingParam[1]);
		}
		return (List) query.getResultList();
	}
}
