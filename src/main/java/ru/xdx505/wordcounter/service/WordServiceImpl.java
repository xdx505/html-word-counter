package ru.xdx505.wordcounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.xdx505.wordcounter.data.dto.PageDto;
import ru.xdx505.wordcounter.data.dto.WordDto;
import ru.xdx505.wordcounter.data.model.Page;
import ru.xdx505.wordcounter.data.model.Word;
import ru.xdx505.wordcounter.data.repository.WordRepository;
import ru.xdx505.wordcounter.mapper.MappingHelper;

@Service
@Transactional
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final MappingHelper mappingHelper;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository, MappingHelper mappingHelper) {
        this.wordRepository = wordRepository;
        this.mappingHelper = mappingHelper;
    }

    @Override
    public Word save(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public Word getById(long id) {
        return wordRepository.getById(id);
    }

    @Override
    public WordDto save(String word, int count, PageDto page) {
        var wordEntity = new Word();
        wordEntity.setWord(word);
        wordEntity.setCount(count);
        wordEntity.setPage(mappingHelper.map(page, Page.class));
        var savedWordEntity = save(wordEntity);
        return mappingHelper.map(savedWordEntity, WordDto.class);
    }
}
