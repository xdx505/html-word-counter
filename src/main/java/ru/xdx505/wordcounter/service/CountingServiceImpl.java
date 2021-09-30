package ru.xdx505.wordcounter.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Реализация сервиса подсчётов
 */
@Service
public class CountingServiceImpl implements CountingService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Integer> countWords(String text, int wordMinLength) throws BadAttributeValueExpException, EntityNotFoundException {
        if (wordMinLength < 1 || wordMinLength > 64)
            throw new BadAttributeValueExpException(wordMinLength);
        var map = new LinkedHashMap<String, Integer>();
        var splintedText = Arrays.asList(text.toUpperCase().trim().replaceAll("[^A-ZА-Я]", " ").split(" "));
        splintedText.forEach(st -> {
            if (!st.equals(StringUtils.EMPTY) && st.length() >= wordMinLength) {
                int count = map.getOrDefault(st, 0);
                map.put(st, count + 1);
            }
        });
        if (map.isEmpty())
            throw new EntityNotFoundException("На страницу нет слов, в которых " + wordMinLength + " и более букв");
        return sortByValue(map);
    }

    /**
     * Сортирует по значению
     *
     * @param map любая карта
     * @return отсортированную по значению карту
     */
    private Map<String, Integer> sortByValue(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
