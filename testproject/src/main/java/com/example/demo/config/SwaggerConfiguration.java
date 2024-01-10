package com.example.demo.config;

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
public class SwaggerConfiguration {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				// basePackage : 스웨거가 RestController가 등록된 것들을 모두 스캔하는데, 그 스캔 범위를 지정
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		// ApiInfo중에서 필요 없는 파라미터들은 거르면서 사용하기 위해 ApiInfoBuilder 사용
		return new ApiInfoBuilder()
				.title("스프링부트 연습 with Swagger")
				.description("파이팅입니당")
				.version("1.0")
				.build();
	}

}
