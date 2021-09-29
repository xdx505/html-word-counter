package ru.xdx505.wordcounter.service;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityNotFoundException;
import java.util.Map;

/**
 * Сервис подсчётов
 */
public interface CountingService {
    /**
     * Подсчитывает кол-во слов в тексте. Задается минимальное число букв в слове.
     * Текст разделяется по словам через регулярное выражение. Затем подсчитывается кол-во каждого слова.
     *
     * @param text          входной текст
     * @param wordMinLength минимальное число букв в слове
     * @return карта (слово-количество)
     * @throws BadAttributeValueExpException когда неправильно задана длина слова (менее 1 или боле 64 символов)
     * @throws EntityNotFoundException       когда не находит слов на странице по заданному диапазону
     */
    Map<String, Integer> countWords(String text, int wordMinLength) throws BadAttributeValueExpException, EntityNotFoundException;
}
