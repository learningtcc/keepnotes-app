package org.osanchezh.keepnotes.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.osanchezh.keepnotes.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:src/main/resources/spring/keepnotes-soa-services/keepnotes-servicesAppCtx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	private static final Logger LOGGER =  LoggerFactory.getLogger(UserServiceTest.class);
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	

	@Test
	public void testUserService() throws Exception{
		LOGGER.debug(".INIT.");
		LOGGER.debug("userService.loadUsers().size()="+userService.loadUsers().size());
		
	}
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
