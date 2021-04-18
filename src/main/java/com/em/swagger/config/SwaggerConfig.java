package com.em.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2).groupName("ashok-group")  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
	 
	 private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("EmployeeManagement API")
					.description("EmployeeManagement  API")
					.termsOfServiceUrl("http://www.employeemanagement .com")
					.contact("javainuse@gmail.com").license("JavaInUse License")
					.licenseUrl("panditashok1196@gmail.com").version("1.0").build();
		}

}
