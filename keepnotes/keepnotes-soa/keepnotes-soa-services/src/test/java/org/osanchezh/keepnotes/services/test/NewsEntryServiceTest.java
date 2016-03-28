package org.osanchezh.keepnotes.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.osanchezh.keepnotes.services.NewsEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:src/main/resources/spring/keepnotes-soa-services/keepnotes-servicesAppCtx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NewsEntryServiceTest {
	private static final Logger LOGGER =  LoggerFactory.getLogger(NewsEntryServiceTest.class);

	@Autowired
	@Qualifier("newsEntryService")
	private NewsEntryService newsEntryService;

	@Test
	public void testNewsEntryService(){
		LOGGER.debug("test");
	}
	public NewsEntryService getNewsEntryService() {
		return newsEntryService;
	}

	public void setNewsEntryService(NewsEntryService newsEntryService) {
		this.newsEntryService = newsEntryService;
	}
}
