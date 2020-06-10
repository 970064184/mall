package com.mall.web.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger 基本配置
 * @author zb
 *
 */
@Configuration
@ConditionalOnProperty(name="swagger.enable", havingValue="enable")
@Import({ Swagger2DocumentationConfiguration.class })
public class Swagger2Config {
	@Bean
	public Docket createRestApi() {

		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("接口文档")
				.description("swagger文档")
				// .termsOfServiceUrl("http://www.baidu.com")
//				.contact(new Contact("hello world", "", "970064184@qq.com"))
				.version("1.0.0")
				.license("Apache 2.0")
//				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();

		List<Parameter> headers = new ArrayList();
		headers.add(new ParameterBuilder()
				.name("Authorization")
				.defaultValue("Bearer access_token")
				.description("用户accessToken,单词“Bearer”和其后面的一个空格保留")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.build());
		//Predicate<RequestHandler> requestHandlerPredicate = RequestHandlerSelectors.basePackage("com.huidiancloud");
		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(headers)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build();
	}

}
