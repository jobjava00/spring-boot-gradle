package com.github.jobjava00.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jobjava00
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)  //스웨거 문서 생성을 설정하는 빌더 클래스
				.select()
				.apis(RequestHandlerSelectors.any())    //문서의 모든 API와 경로를 포함
				.paths(PathSelectors.any())
				.build();
	}
}
