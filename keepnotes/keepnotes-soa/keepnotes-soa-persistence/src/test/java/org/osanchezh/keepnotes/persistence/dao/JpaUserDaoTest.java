package org.osanchezh.keepnotes.persistence.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.osanchezh.keepnotes.persistence.dao.impl.newsentry.NewsEntryDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:src/main/resources/spring/keepnotes-soa-persistence/keepnotes-dbconfig-persistenceAppCtx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaUserDaoTest {
	private static final Logger LOGGER =  LoggerFactory.getLogger(KNTUserDAOTest.class);

	@Autowired
	private NewsEntryDaoImpl NewsEntryDao;

    @Test
    public void testkntuserDAO() {
      LOGGER.info("INFO");
      int resultado = NewsEntryDao.findAll().size();
      LOGGER.debug("RESULTADO="+resultado);
      LOGGER.debug("TEST");
    }
	
	public NewsEntryDaoImpl getNewsEntryDao() {
		return NewsEntryDao;
	}

	public void setNewsEntryDao(NewsEntryDaoImpl newsEntryDao) {
		NewsEntryDao = newsEntryDao;
	}

}
