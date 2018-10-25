package com.cf.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * @author	:	Subbu
 * @class	:	Swagger2Config.java
 * @discription:	Class exposes all API used under the package of com.ta.tracking.controller
 * 
 * Accessible through : http://<host>:<port>/swagger-ui.html
 * 						http://localhost:8081/swagger-ui.html
 * 
 * 
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cf.user.controller")).build();
	}

}
