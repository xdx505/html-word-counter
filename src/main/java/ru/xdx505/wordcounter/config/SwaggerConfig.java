package ru.xdx505.wordcounter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final ApiInfoConfig apiInfoConfig;

    @Autowired
    public SwaggerConfig(ApiInfoConfig apiInfoConfig) {
        this.apiInfoConfig = apiInfoConfig;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfo(
                                apiInfoConfig.getTitle(), apiInfoConfig.getDescription(),
                                apiInfoConfig.getVersion(), apiInfoConfig.getTerms(),
                                new Contact(apiInfoConfig.getContactName(), apiInfoConfig.getContactUrl(), apiInfoConfig.getContactEmail()),
                                apiInfoConfig.getLicense(), apiInfoConfig.getLicenseUrl(), new ArrayList<>()
                        ))
                .consumes(new HashSet<>(Collections.singletonList("application/json")))
                .produces(new HashSet<>(Collections.singletonList("application/json")));
    }
}
