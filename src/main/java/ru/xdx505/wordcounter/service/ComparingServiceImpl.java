package ru.xdx505.wordcounter.service;

import org.springframework.stereotype.Service;
import ru.xdx505.wordcounter.data.dto.WordResponseDto;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Реализация общего сервиса
 */
@Service
public class ComparingServiceImpl implements ComparingService {
    private final CountingService countingService;
    private final ParsingService parsingService;

    public ComparingServiceImpl(CountingService countingService, ParsingService parsingService) {
        this.countingService = countingService;
        this.parsingService = parsingService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<WordResponseDto> returnWordsStat(String uri, int wordMinLength) throws IOException, BadAttributeValueExpException, EntityNotFoundException {
        var pageToText = parsingService.getPageAsText(uri);
        var wordsMap = countingService.countWords(pageToText, wordMinLength);
        return wordsMap.entrySet().stream()
                .map(wc -> new WordResponseDto(wc.getKey(), wc.getValue()))
                .sorted(Comparator.comparing(WordResponseDto::getCount).reversed().thenComparing(WordResponseDto::getWord))
                .collect(Collectors.toList());
    }
}
