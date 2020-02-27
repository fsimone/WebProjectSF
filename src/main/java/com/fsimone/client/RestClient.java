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
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.AsyncRestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fsimone.client.dto.JacksonClassDTO;



@SuppressWarnings("deprecation")
public class RestClient {
	
    private static final Logger LOG = LogManager.getLogger(RestClient.class);


	final String uri = "http://localhost:8080/WebProjectSpringFrameWork/endpoint/listj";
	private RestTemplate restTemplate = null;
	private AsyncRestTemplate asyncRestTemplate = null;
    private ObjectMapper mapperJackson = null;

	
	public RestClient() {
		Configurator.setLevel("com.fsimone.client.RestClient", Level.ALL);
		
		restTemplate = new RestTemplate();
		asyncRestTemplate = new AsyncRestTemplate();
		mapperJackson = new ObjectMapper();

	}

	public void testSynchGET() {
		
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
			LOG.info("*** Jackson : " + javaObj.toString());
			LOG.info("************");

		}catch (Exception e) {
			LOG.error(e.getMessage());
		}
		


		
	}
	
	
	public void testAsynchGET() {
		
		try {
			 HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

		 	 ListenableFuture<ResponseEntity<String>> response = asyncRestTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class, "0");
		     response.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
		            @Override
		            public void onSuccess(ResponseEntity<String> result) {
		            	LOG.info("************");
		    			LOG.info("*** Status : " + result.getStatusCodeValue());
		    			LOG.info("*** Header : " + result.getHeaders());
		    			LOG.info("*** Body   : " + result.getBody());
		    			LOG.info("************");
		            }

		            @Override
		            public void onFailure(Throwable e) {
		    			LOG.error(e.getMessage());
		            }
		        });
        } catch (Exception e) {
            
        }
		
		
	}

}
