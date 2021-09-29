package ru.xdx505.wordcounter.service;

import ru.xdx505.wordcounter.data.dto.PageDto;
import ru.xdx505.wordcounter.data.model.Page;

public interface PageService {
    Page save(Page page);

    Page getById(long id);

    PageDto save(String uri);
}
