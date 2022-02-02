package org.serratec.backend.configuration;


import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket alunoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo());
		
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Ecommerce API REST",
				"API REST Ecommerce",
				"1.0",
				"Terms of service",
				new Contact ("Grupo 2 Serrablocks", "Serrablocks.com","https://serrablocks.netlify.app" ),
				"Apache License Version 2.0","Https://apache.org/license.html",
				new ArrayList<VendorExtension>()
				);
		return apiInfo;
	}
	
}