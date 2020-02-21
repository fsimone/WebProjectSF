package com.fsimone.hibernate.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsimone.hibernate.entity.TestEntity;
import com.fsimone.hibernate.service.TestEntityService;

import org.springframework.context.ApplicationContext;


@RestController
@RequestMapping(path = "/endpoint")
public class FSRestController {

    private static final Logger LOG = LogManager.getLogger(FSRestController.class);


    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private TestEntityService testEntityService;



	@GetMapping(path="/list", produces = "application/json")
    public Collection<String> getLogs() {
		LOG.info("return all DB elements");
		//curl -X GET http://localhost:8080/WebProjectSpringFrameWork/endpoint/list
        List<TestEntity> list = testEntityService.getTestEntityList();
        Collection<String> collection =  list.stream().filter(o -> o instanceof TestEntity)
        	    .map(o -> (String) o.getDescription()).collect(Collectors.toList());
		return collection;
    }



	@PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addLog(@RequestBody String param) {
		LOG.info("add element to DB");
		//curl -X POST --header "Content-Type: application/json" http://localhost:8080/WebProjectSpringFrameWork/endpoint/add --data 'test'
		TestEntity value = new TestEntity();
		value.setDescription(param);
		testEntityService.saveTestEntity(value);
		return null;

	}




}
