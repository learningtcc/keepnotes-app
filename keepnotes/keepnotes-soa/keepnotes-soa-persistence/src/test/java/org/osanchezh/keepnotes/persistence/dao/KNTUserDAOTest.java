package org.osanchezh.keepnotes.persistence.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:spring/keepnotes-soa-persistence/persistence-databaseconfiguration.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class KNTUserDAOTest {
	private static final Logger LOGGER =  LoggerFactory.getLogger(KNTUserDAOTest.class);
	
	
    @Autowired
    private KNTUserDAO kntuserDAO;
    
    
    @Test
    public void testkntuserDAO() {
    	Integer size = kntuserDAO.selectUsers().size();
    	LOGGER.debug("SIZE="+size);
    }
    
	public KNTUserDAO getKntuserDAO() {
		return kntuserDAO;
	}
	public void setKntuserDAO(KNTUserDAO kntuserDAO) {
		this.kntuserDAO = kntuserDAO;
	}
    
}
