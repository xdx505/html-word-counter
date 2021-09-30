package ru.xdx505.wordcounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.xdx505.wordcounter.data.dto.PageDto;
import ru.xdx505.wordcounter.data.dto.PageStatsDto;
import ru.xdx505.wordcounter.data.model.WebPage;
import ru.xdx505.wordcounter.data.repository.PageRepository;
import ru.xdx505.wordcounter.mapper.MappingHelper;

import java.util.stream.Collectors;

@Service
@Transactional
public class PageServiceImpl implements PageService {
    private final PageRepository pageRepository;
    private final MappingHelper mappingHelper;

    @Autowired
    public PageServiceImpl(PageRepository pageRepository, MappingHelper mappingHelper) {
        this.pageRepository = pageRepository;
        this.mappingHelper = mappingHelper;
    }

    @Override
    public WebPage save(WebPage page) {
        return pageRepository.save(page);
    }

    @Override
    public WebPage getById(long id) {
        return pageRepository.getById(id);
    }

    @Override
    public PageDto save(String uri) {
        var page = new WebPage();
        page.setUrl(uri);
        var savedPage = save(page);
        return mappingHelper.map(savedPage, PageDto.class);
    }

    @Override
    public Page<PageStatsDto> getAllPagesByUri(String uri, Pageable pageable) {
        var webPage = pageRepository.getAllByUrlOrderByCreatedAt(uri);
        var mappedPages = webPage.stream()
                .map(p -> {
                    var pageStatsDto = mappingHelper.map(p, PageStatsDto.class);
                    pageStatsDto.setUniqueWordsCount(p.getWords().size());
                    return pageStatsDto;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(mappedPages, pageable, mappedPages.size());
    }
}
