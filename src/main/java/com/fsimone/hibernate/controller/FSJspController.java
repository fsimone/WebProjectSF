package com.fsimone.hibernate.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fsimone.hibernate.entity.TestEntity;
import com.fsimone.hibernate.service.TestEntityService;



@Controller
public class FSJspController {

    private static final Logger LOG = LogManager.getLogger(FSJspController.class);


    @Autowired
    private TestEntityService testEntityService;

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "This is a test message";


    /*
     * http://localhost:8080/WebProjectSpringFrameWork/test
     */
    @GetMapping("/test")
    public String test(Model model) {
        List<TestEntity> list = testEntityService.getTestEntityList();
        model.addAttribute("databaserow", list);
        return "test";
    }



	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	
	
/*
	@RequestMapping(value = "/addLog", method = RequestMethod.GET)
	public ModelAndView addLog( @ModelAttribute("log") Log log) {
		return new ModelAndView( "logAdd" );
	}
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewLogs() {
		Map<String, List<?>> model = new HashMap<String, List<?>>();
		//model.put ( "users", logService.getLogs() );

		return new ModelAndView( "userView", model );
	}
 */

}
