package org.osanchezh.keepnotes.soa.app.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.osanchezh.keepnotes.soa.integration.api.domain.TokenTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

public class SecurityNewsEntryRestTest {
	   public static final String URL = "http://localhost:8081/keepnotes-soa-app/rest/news";
	   public static final String URL_SECURITY = "http://localhost:8081/keepnotes-soa-app/rest/user/authenticate";

		private static final Logger LOGGER =  LoggerFactory.getLogger(SecurityNewsEntryRestTest.class);
		
		
		@Test
		public void testLoginRestService(){
			try{
			    RestTemplate restTemplate = new RestTemplate();

				MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
				map.add("username", "admin");
				map.add("password", "admin");  

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);      

				HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

				List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
				messageConverters.add(new MappingJacksonHttpMessageConverter());    
				messageConverters.add(new FormHttpMessageConverter());
				restTemplate.setMessageConverters(messageConverters);

				TokenTransfer tokenTransfer = restTemplate.postForObject(URL_SECURITY, request, TokenTransfer.class);
				String token1=tokenTransfer.getToken();
				LOGGER.debug("token="+token1);

				RestTemplate restTemplate1 = new RestTemplate();

			    
			    HttpHeaders headers1= new HttpHeaders();
			    headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			    headers1.add("X-Auth-Token", token1);
			    
			   
			    HttpEntity<String> entity1 = new HttpEntity<String>("request", headers1);
			    ResponseEntity<String> result1 = restTemplate1.exchange(URL, HttpMethod.GET, entity1 ,String.class);
			    
			    LOGGER.debug("RESULTADO="+result1.getBody());
			    
				}catch(ResourceAccessException ex){
					LOGGER.error(ex.getMessage(),ex);
				}
			
		}
		//@Test
		public void testGetRestService(){
			try{
		    RestTemplate restTemplate = new RestTemplate();

			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("username", "admin");
			map.add("password", "admin");  

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);      

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			messageConverters.add(new MappingJacksonHttpMessageConverter());    
			messageConverters.add(new FormHttpMessageConverter());
			restTemplate.setMessageConverters(messageConverters);

			TokenTransfer tokenTransfer = restTemplate.postForObject(URL_SECURITY, request, TokenTransfer.class);
			LOGGER.debug("token="+tokenTransfer.getToken());

			/*
			RestTemplate template1 = new RestTemplate();

			MultiValueMap map2 = new LinkedMultiValueMap();
			map.add("X-Auth-Token",tokenTransfer.getToken());
			HttpHeaders headers1 = new HttpHeaders();
			//headers1.setContentType(new MediaType("multipart", "form-data"));
			HttpEntity request1 = new HttpEntity(map2, headers1);
			ResponseEntity<String> httpResponse = template1.exchange(URL, HttpMethod.GET, request1, String.class);
			*/

			}catch(ResourceAccessException ex){
				LOGGER.error(ex.getMessage(),ex);
			}
			
		}
		
		

		//@Test
		public void testGetRestService2(){
			try{
		    RestTemplate restTemplate = new RestTemplate();

		    
		    HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    headers.add("X-Auth-Token", "user:1461466423029:dce73150343b033e2c56fab50c7a25db");
		    
		   
		    HttpEntity<String> entity = new HttpEntity<String>("request", headers);
		    ResponseEntity<String> result = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
		    
		    LOGGER.debug("RESULTADO="+result.getBody());
		    /*
		    
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("token", "admin:1460164887842:17de642b86d939f238e7e0d6e168bcf6");
			//map.add("password", "admin");  

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);      

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			messageConverters.add(new MappingJacksonHttpMessageConverter());    
			messageConverters.add(new FormHttpMessageConverter());
			restTemplate.setMessageConverters(messageConverters);

			TokenTransfer tokenTransfer = restTemplate.postForObject(URL, request, TokenTransfer.class);
			LOGGER.debug("token="+tokenTransfer.getToken());
*/
			/*
			RestTemplate template1 = new RestTemplate();

			MultiValueMap map2 = new LinkedMultiValueMap();
			map.add("X-Auth-Token",tokenTransfer.getToken());
			HttpHeaders headers1 = new HttpHeaders();
			//headers1.setContentType(new MediaType("multipart", "form-data"));
			HttpEntity request1 = new HttpEntity(map2, headers1);
			ResponseEntity<String> httpResponse = template1.exchange(URL, HttpMethod.GET, request1, String.class);
			*/

			}catch(ResourceAccessException ex){
				LOGGER.error(ex.getMessage(),ex);
			}
			
		}
		
}
