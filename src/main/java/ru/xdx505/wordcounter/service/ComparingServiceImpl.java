package ru.xdx505.wordcounter.service;

import org.springframework.stereotype.Service;
import ru.xdx505.wordcounter.data.dto.WordResponseDto;
import ru.xdx505.wordcounter.mapper.MappingHelper;

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
    private final PageService pageService;
    private final WordService wordService;
    private final MappingHelper mappingHelper;

    public ComparingServiceImpl(
            CountingService countingService,
            ParsingService parsingService,
            PageService pageService,
            WordService wordService,
            MappingHelper mappingHelper
    ) {
        this.countingService = countingService;
        this.parsingService = parsingService;
        this.pageService = pageService;
        this.wordService = wordService;
        this.mappingHelper = mappingHelper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<WordResponseDto> returnWordsStat(String uri, int wordMinLength) throws IOException, BadAttributeValueExpException, EntityNotFoundException {
        var pageDto = pageService.save(uri);
        var pageToText = parsingService.getPageAsText(uri);
        var wordsMap = countingService.countWords(pageToText, wordMinLength);
        return wordsMap.entrySet().stream()
                .map(wc -> {
                    var wordDto = wordService.save(wc.getKey(), wc.getValue(), pageDto);
                    return mappingHelper.map(wordDto, WordResponseDto.class);
                })
                .sorted(Comparator.comparing(WordResponseDto::getCount).reversed().thenComparing(WordResponseDto::getWord))
                .collect(Collectors.toList());
    }
}
