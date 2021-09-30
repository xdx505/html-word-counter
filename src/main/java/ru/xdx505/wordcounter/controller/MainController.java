package ru.xdx505.wordcounter.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.xdx505.wordcounter.data.dto.PageResponseDto;
import ru.xdx505.wordcounter.data.dto.PageStatsDto;
import ru.xdx505.wordcounter.service.ComparingService;
import ru.xdx505.wordcounter.service.PageService;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;

/**
 * Главный контроллер
 */
@RestController
@RequestMapping("api/v1/main")
public class MainController {

    private final ComparingService comparingService;
    private final PageService pageService;

    @Autowired
    public MainController(ComparingService comparingService, PageService pageService) {
        this.comparingService = comparingService;
        this.pageService = pageService;
    }

    @ApiOperation(value = "Возвращает статистику слов на сайте")
    @GetMapping
    public PageResponseDto getUriWordStats(
            @RequestParam String uri,
            @RequestParam int minWordLength
    ) throws IOException, BadAttributeValueExpException, EntityNotFoundException {
        return comparingService.returnWordsStat(uri, minWordLength);
    }

    @ApiOperation(value = "Возвращает статистику всех поисков по uri")
    @GetMapping("/stats/uri")
    public Page<PageStatsDto> getPages(
            @RequestParam String uri,
            Pageable pageable
    ) {
        return pageService.getAllPagesByUri(uri, pageable);
    }
}
