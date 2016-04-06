package org.osanchezh.keepnotes.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.osanchezh.keepnotes.persistence.dao.impl.newsentry.JpaNewsEntryDaoImpl;
import org.osanchezh.keepnotes.soa.model.entity.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;


public class JpaDao<T extends Entity, I> implements Dao<T, I>
{
	private static final Logger LOGGER =  LoggerFactory.getLogger(JpaDao.class);


	private EntityManager entityManager;

	protected Class<T> entityClass;


	public JpaDao(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}


	public EntityManager getEntityManager()
	{
		return this.entityManager;
	}


	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}


	
	@Transactional(readOnly = true)
	public List<T> findAll()
	{
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = builder.createQuery(this.entityClass);

		criteriaQuery.from(this.entityClass);

		TypedQuery<T> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}



	@Transactional(readOnly = true)
	public T find(I id)
	{
		return this.getEntityManager().find(this.entityClass, id);
	}



	@Transactional
	public T save(T entity)
	{
		LOGGER.debug("OBJETO.GUARDADO....");
		T mobjeto= this.getEntityManager().merge(entity);

		return mobjeto;
		
	}



	@Transactional
	public void delete(I id)
	{
		if (id == null) {
			return;
		}

		T entity = this.find(id);
		if (entity == null) {
			return;
		}

		this.getEntityManager().remove(entity);
	}

}