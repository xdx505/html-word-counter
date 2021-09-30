package ru.xdx505.wordcounter.service;

import ru.xdx505.wordcounter.data.dto.PageResponseDto;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;

/**
 * Общий сервис
 */
public interface ComparingService {

    /**
     * Получает коллекцию слов
     *
     * @param uri           ссылка на страницу
     * @param wordMinLength минимальное число букв в слове
     * @return {@link PageResponseDto}
     * @throws IOException                   если есть проблемы со ссылкой или доступом к странице
     * @throws BadAttributeValueExpException когда неправильно задана длина слова (менее 1 или боле 64 символов)
     * @throws EntityNotFoundException       когда не находит слов на странице по заданному диапазону
     */
    PageResponseDto returnWordsStat(String uri, int wordMinLength) throws IOException, BadAttributeValueExpException, EntityNotFoundException;
}
