package com.sanjib.hcl.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties")
public class LearnController {

	// By using @value annotation
	@Value("${learnapp.message}")
	private String envMessage;

	// By Using Environment variable
	@Autowired
	private Environment env;

	// By Using Environment variable
	//@Autowired
	private Properties props= new Properties();
	@GetMapping(value = "/welcomemsg")
	public String welcomeMsg() {
		String profile = env.getProperty("learnapp.message");
		String prof=props.getProperty("learnapp.message");
		System.out.println("Environment : " + envMessage + " " + profile+" "+prof);
		return "welcome To Spring Boot";

	}// welcomeMsg()

}// class
