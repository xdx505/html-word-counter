package ru.xdx505.wordcounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.xdx505.wordcounter.data.dto.PageDto;
import ru.xdx505.wordcounter.data.model.Page;
import ru.xdx505.wordcounter.data.repository.PageRepository;
import ru.xdx505.wordcounter.mapper.MappingHelper;

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
    public Page save(Page page) {
        return pageRepository.save(page);
    }

    @Override
    public Page getById(long id) {
        return pageRepository.getById(id);
    }

    @Override
    public PageDto save(String uri) {
        var page = new Page();
        page.setUrl(uri);
        var savedPage = save(page);
        return mappingHelper.map(savedPage, PageDto.class);
    }
}
