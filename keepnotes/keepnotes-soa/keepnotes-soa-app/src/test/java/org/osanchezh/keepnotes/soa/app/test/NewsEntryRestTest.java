package org.osanchezh.keepnotes.soa.app.test;

import java.net.ConnectException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

//@RunWith(SpringJUnit4ClassRunner.class)
public class NewsEntryRestTest {
   public static final String URL = "http://localhost:8081/keepnotes-soa-app/rest/news";
	private static final Logger LOGGER =  LoggerFactory.getLogger(NewsEntryRestTest.class);
 

	@Test
	public void testGetRestService(){
	    RestTemplate restTemplate = new RestTemplate();
	    LOGGER.debug("testGetRestService");
	    //HttpHeaders headers = new HttpHeaders();
	    //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    //HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	    //ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	    try{
	    String cadena ="";
	    cadena = restTemplate.getForObject(URL, String.class);
	    LOGGER.debug("cadena.json="+cadena);
	    }catch(ResourceAccessException ex){
	    	LOGGER.error(ex.getMessage(),ex);
	    }
	}
}
