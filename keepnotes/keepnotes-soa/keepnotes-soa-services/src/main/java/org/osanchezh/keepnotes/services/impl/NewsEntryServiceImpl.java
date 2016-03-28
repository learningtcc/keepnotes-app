package org.osanchezh.keepnotes.services.impl;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.osanchezh.keepnotes.persistence.dao.JpaNewsEntryDaoTest;
import org.osanchezh.keepnotes.persistence.dao.impl.newsentry.NewsEntryDao;
import org.osanchezh.keepnotes.services.NewsEntryService;
import org.osanchezh.keepnotes.soa.model.entity.NewsEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("newsEntryService")
public class NewsEntryServiceImpl implements NewsEntryService {
    
	private static final Logger LOGGER =  LoggerFactory.getLogger(NewsEntryServiceImpl.class);

	@Autowired
	@Qualifier("jpaNewsEntryDao")
	private NewsEntryDao jpaNewsEntryDao;
	
	
	public List<NewsEntry> list() {
		List<NewsEntry> allEntries = this.jpaNewsEntryDao.findAll();
		return allEntries;
	}

	public NewsEntry read(Long id) {
		this.LOGGER.info("read(id)");

		NewsEntry newsEntry = this.jpaNewsEntryDao.find(id);
		if (newsEntry == null) {
			throw new WebApplicationException(404);
		}
		return newsEntry;
	}

	public NewsEntry create(NewsEntry newsEntry) {
		return this.jpaNewsEntryDao.save(newsEntry);
		
	}

	public NewsEntry update(Long id, NewsEntry newsEntry) {
		return this.jpaNewsEntryDao.save(newsEntry);
	}

	public void delete(Long id) {
		jpaNewsEntryDao.delete(id);		
	}


	public NewsEntryDao getJpaNewsEntryDao() {
		return jpaNewsEntryDao;
	}

	public void setJpaNewsEntryDao(NewsEntryDao jpaNewsEntryDao) {
		this.jpaNewsEntryDao = jpaNewsEntryDao;
	}
}
