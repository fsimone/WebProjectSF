package com.fsimone.hibernate.controller;


import java.util.Collection;
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

import org.springframework.context.ApplicationContext;


@RestController
@RequestMapping(path = "/endpoint")
public class FSRestController {

    private static final Logger LOG = LogManager.getLogger(FSRestController.class);


    @Autowired
    private ApplicationContext applicationContext;



	@GetMapping(path="/logs", produces = "application/json")
    public Collection<String> getLogs()
    {
		LOG.info("metodo rest getLogs");
		//applicationContext.getBean("");
		return IntStream.range(0, 10)
		          .mapToObj(i -> "Hello number " + i)
		          .collect(Collectors.toList());
    }



	@PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addLog(@RequestBody TestEntity te) {
		return null;

	}




}
