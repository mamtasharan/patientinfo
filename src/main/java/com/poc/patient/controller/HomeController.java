package com.poc.patient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static Logger logger = LoggerFactory.getLogger(HomeController.class.getName());

	
 @RequestMapping("/home")
 public String home() {
	 logger.info("redirecting to index page");
  return "/views/index.html";
 }
}