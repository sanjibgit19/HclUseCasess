package com.sanjib.hcl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket docket() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2);
		return docket
			   .select()
			   .apis(RequestHandlerSelectors.basePackage("com.sanjib.hcl.controller"))
			   .paths(PathSelectors.any())
			   .build()
			   .apiInfo(apiInfo());
	}//docket(-------)
	
	
	public ApiInfo apiInfo() {
		Contact contact=new Contact("sanjib","HCL","HCL");
		ApiInfo apiInfo=new ApiInfo("SpringBoot and Microservices",
				"For HclUseCases",
				"2.x", 
				"hcl.com",
				contact,
				"Appache license",
				"Appache.org"	);
		
		return apiInfo;
	}//appInfo()

}//class