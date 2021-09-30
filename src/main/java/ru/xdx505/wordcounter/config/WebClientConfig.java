package ru.xdx505.wordcounter.config;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.javascript.SilentJavaScriptErrorListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientConfig {
    @Autowired
    private WebClientOptionsConfig webOp;

    @Bean
    public WebClient webClient() {
        var webClient = new WebClient(BrowserVersion.CHROME);
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        webClient.setJavaScriptErrorListener(new SilentJavaScriptErrorListener());
        var op = webClient.getOptions();
        op.setThrowExceptionOnScriptError(false);
        op.setThrowExceptionOnFailingStatusCode(false);
        op.setDownloadImages(false);
        op.setTimeout(webOp.getTimeout());
        op.setJavaScriptEnabled(webOp.isJavaScriptEnabled());
        op.setCssEnabled(webOp.isCssEnabled());
        op.setMaxInMemory(webOp.getMaxBytesInMemory());
        op.setScreenHeight(webOp.getScreenHeight());
        op.setScreenWidth(webOp.getScreenWidth());
        return webClient;
    }
}
