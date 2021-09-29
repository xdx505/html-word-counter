package ru.xdx505.wordcounter.data.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import ru.xdx505.wordcounter.data.model.Page;

@Data
public class WordDto {
    private Long id = 0L;
    private String word = StringUtils.EMPTY;
    private int count = 0;
    private Page page = new Page();
}
