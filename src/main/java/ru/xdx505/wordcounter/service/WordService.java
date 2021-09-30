package ru.xdx505.wordcounter.service;

import ru.xdx505.wordcounter.data.dto.PageDto;
import ru.xdx505.wordcounter.data.dto.WordDto;
import ru.xdx505.wordcounter.data.model.Word;

public interface WordService {
    Word save(Word word);

    Word getById(long id);

    WordDto save(String word, int count, PageDto page);
}
