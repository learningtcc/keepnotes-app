package org.osanchezh.keepnotes.persistence.dao.impl.newsentry;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.osanchezh.keepnotes.persistence.dao.JpaDao;
import org.osanchezh.keepnotes.soa.model.entity.NewsEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * JPA Implementation of a {@link NewsEntryDao}.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
@Repository("jpaNewsEntryDao")
public class JpaNewsEntryDaoImpl extends JpaDao<NewsEntry, Long> implements NewsEntryDao
{
	private static final Logger LOGGER =  LoggerFactory.getLogger(JpaNewsEntryDaoImpl.class);

	public JpaNewsEntryDaoImpl()
	{
		super(NewsEntry.class);
	}


	@Override
	@Transactional(readOnly = true)
	public List<NewsEntry> findAll()
	{
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<NewsEntry> criteriaQuery = builder.createQuery(NewsEntry.class);

		Root<NewsEntry> root = criteriaQuery.from(NewsEntry.class);
		criteriaQuery.orderBy(builder.desc(root.get("date")));

		TypedQuery<NewsEntry> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

}
