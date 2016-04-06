package org.osanchezh.keepnotes.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.osanchezh.keepnotes.services.NewsEntryService;
import org.osanchezh.keepnotes.services.UserEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:src/main/resources/spring/keepnotes-soa-services/keepnotes-servicesAppCtx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserEntryServiceTest {
	private static final Logger LOGGER =  LoggerFactory.getLogger(UserEntryServiceTest.class);

	@Autowired
	@Qualifier("userEntryService")
	private UserEntryService userEntryService;

	@Test
    public void testContadorUsuarios(){
		LOGGER.debug("init.testContadorUsuarios");
		LOGGER.debug("-cantidad="+userEntryService.findAll().size());
    }
	
	
	public UserEntryService getUserEntryService() {
		return userEntryService;
	}

	public void setUserEntryService(UserEntryService userEntryService) {
		this.userEntryService = userEntryService;
	}
	
}
