package ru.xdx505.wordcounter.service;

import java.io.IOException;

/**
 * Сервис парсинга
 */
public interface ParsingService {
    /**
     * Парсит страницу и возвращает нормализованный текст.
     *
     * @param uri uri страницы
     * @return нормализованный текст, разделённый отступами
     * @throws IOException если есть проблемы со ссылкой или доступом к странице
     */
    String getPageAsText(String uri) throws IOException;
}
