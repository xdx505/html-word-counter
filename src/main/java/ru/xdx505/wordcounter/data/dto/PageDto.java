package ru.xdx505.wordcounter.data.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import ru.xdx505.wordcounter.data.model.Word;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;

@Data
public class PageDto {
    private Long id = 0L;
    private String url = StringUtils.EMPTY;
    private Collection<Word> words = Collections.emptyList();
    private ZonedDateTime createdAt = ZonedDateTime.now();
}
