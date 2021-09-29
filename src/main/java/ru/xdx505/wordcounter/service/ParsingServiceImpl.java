package ru.xdx505.wordcounter.service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;

/**
 * Реализация сервиса парсинга
 */
@Service
public class ParsingServiceImpl implements ParsingService {
    private final WebClient webClient;

    @Autowired
    public ParsingServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPageAsText(String uri) throws IOException {
        String pageAsText;
        try (webClient) {
            var page = (HtmlPage) webClient.getPage(new URL(uri));
            pageAsText = page.asNormalizedText();
        }
        if (pageAsText.equals("") || pageAsText.isEmpty()) throw new NullPointerException();
        return pageAsText;
    }
}
