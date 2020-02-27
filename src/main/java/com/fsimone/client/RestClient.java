package com.fsimone.client;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fsimone.client.dto.JacksonClassDTO;


public class RestClient {
	
    private static final Logger LOG = LogManager.getLogger(RestClient.class);


	final String uri = "http://localhost:8080/WebProjectSpringFrameWork/endpoint/listj";
	private RestTemplate restTemplate = null;
    private ObjectMapper mapperJackson = null;

	
	public RestClient() {
		Configurator.setLevel("com.fsimone.client.RestClient", Level.ALL);
		
		restTemplate = new RestTemplate();
		mapperJackson = new ObjectMapper();

	}

	public void testGET() {
		
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//headers.add("Cookie", "null");
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			
			// Consume REST service
			ResponseEntity<String> re = restTemplate.exchange( uri, HttpMethod.GET, requestEntity, String.class );
			//LOG.info("*** ResponseEntity: " + re);
			LOG.info("************");
			LOG.info("*** Status : " + re.getStatusCodeValue());
			LOG.info("*** Header : " + re.getHeaders());
			LOG.info("*** Body   : " + re.getBody());
			LOG.info("************");

			// Convert JSON to java Object with jackson					
			String json = re.getBody();
			JacksonClassDTO javaObj = mapperJackson.readValue(json, JacksonClassDTO.class);
			LOG.debug("\n===> Jackson converted obj  : " + javaObj.toString());

		}catch (Exception e) {
			LOG.error(e.getMessage());
		}
		


		
	}

}
