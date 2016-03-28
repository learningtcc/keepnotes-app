package org.osanchezh.keepnotes.persistence.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.osanchezh.keepnotes.persistence.dao.impl.newsentry.NewsEntryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:src/main/resources/spring/keepnotes-soa-persistence/keepnotes-dbconfig-persistenceAppCtx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNewsEntryDaoTest {
	private static final Logger LOGGER =  LoggerFactory.getLogger(JpaNewsEntryDaoTest.class);

	@Autowired
	@Qualifier("jpaNewsEntryDao")
	private NewsEntryDao jpaNewsEntryDao;

	@Test
    public void testkntuserDAO() {
      LOGGER.info("INFO");
      int resultado = jpaNewsEntryDao.findAll().size();
     
      LOGGER.debug("RESULTADO="+resultado);
      LOGGER.debug("TEST");
    }

	public NewsEntryDao getJpaNewsEntryDao() {
		return jpaNewsEntryDao;
	}


	public void setJpaNewsEntryDao(NewsEntryDao jpaNewsEntryDao) {
		this.jpaNewsEntryDao = jpaNewsEntryDao;
	}

}
