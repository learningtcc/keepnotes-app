package org.osanchezh.keepnotes.soa.integration.test;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osanchezh.keepnotes.soa.integration.rest.controller.NewsEntryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"file:src/main/resources/spring/keepnotes-soa-integration/keepnotes-integrationAppCtx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NewsEntryControllerTest {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(NewsEntryControllerTest.class);
 
	@Autowired
	@Qualifier("newsEntryController")
	private NewsEntryController newsEntryController;

	@Test
	public void testFindAll(){
		  LOGGER.debug("CARGAR.testFindAll");	
		try {
			String lstNewEntry = newsEntryController.list();
			LOGGER.debug("carga="+lstNewEntry);
		} catch (JsonGenerationException e) {
			LOGGER.error(e.getMessage(),e);
		} catch (JsonMappingException e) {
			LOGGER.error(e.getMessage(),e);

		} catch (IOException e) {
			LOGGER.error(e.getMessage(),e);

		}
	}
	
	public NewsEntryController getNewsEntryController() {
		return newsEntryController;
	}

	public void setNewsEntryController(NewsEntryController newsEntryController) {
		this.newsEntryController = newsEntryController;
	}
}
