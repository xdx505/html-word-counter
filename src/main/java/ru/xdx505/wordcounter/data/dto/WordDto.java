package ru.xdx505.wordcounter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordDto {
    private Long id = 0L;
    private String word = StringUtils.EMPTY;
    private int count = 0;
    @ManyToOne
    private PageDto page = new PageDto();

    public WordDto(String word, int count, PageDto page) {
        this.word = word;
        this.count = count;
        this.page = page;
    }
}
