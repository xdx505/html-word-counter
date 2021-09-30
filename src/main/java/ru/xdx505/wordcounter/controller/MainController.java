package ru.xdx505.wordcounter.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.xdx505.wordcounter.data.dto.PageResponseDto;
import ru.xdx505.wordcounter.service.ComparingService;

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

    public MainController(ComparingService comparingService) {
        this.comparingService = comparingService;
    }

    @ApiOperation(value = "Возвращает статистику слов на сайте")
    @GetMapping
    public PageResponseDto getUriWordStats(
            @RequestParam String uri,
            @RequestParam int minWordLength
    ) throws IOException, BadAttributeValueExpException, EntityNotFoundException {
        return comparingService.returnWordsStat(uri, minWordLength);
    }
}
