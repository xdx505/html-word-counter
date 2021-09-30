package ru.xdx505.wordcounter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.xdx505.wordcounter.data.dto.PageDto;
import ru.xdx505.wordcounter.data.dto.PageStatsDto;
import ru.xdx505.wordcounter.data.model.WebPage;

public interface PageService {
    WebPage save(WebPage page);

    WebPage getById(long id);

    PageDto save(String uri);

    Page<PageStatsDto> getAllPagesByUri(String uri, Pageable pageable);
}
