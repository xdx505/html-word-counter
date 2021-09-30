package ru.xdx505.wordcounter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "info")
public class ApiInfoConfig {
    private String title;
    private String description;
    private String version;
    private String contactName;
    private String contactEmail;
    private String contactUrl;
    private String terms;
    private String license;
    private String licenseUrl;
}
