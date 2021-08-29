package com.infy.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2).groupName("com.infy.controller").apiInfo(apiInfo()).select().paths(regex("/Infy.*")).build();
	    }
	 
		private ApiInfo apiInfo() {
	       return new ApiInfoBuilder().title("Employee Service API")
	    		   .description("EMPLOYEE SERVICE API DOCUMENTATION USING SWAGGER")
	    		   .termsOfServiceUrl("").license("EMPLOYEE SERVICE REST API LICENSE")
	    		   .license("").version("1.0").build();
	    }
	    
	   
	    
	    
}