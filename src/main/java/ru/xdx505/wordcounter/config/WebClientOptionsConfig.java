package ru.xdx505.wordcounter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "webclient")
public class WebClientOptionsConfig {
    private int timeout;
    private boolean isJavaScriptEnabled;
    private boolean isCssEnabled;
    private int maxBytesInMemory;
    private int screenHeight;
    private int screenWidth;
}
