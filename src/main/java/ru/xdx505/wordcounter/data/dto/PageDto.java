package ru.xdx505.wordcounter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import ru.xdx505.wordcounter.data.model.Word;

import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {
    private Long id = 0L;
    private String url = StringUtils.EMPTY;

    @OneToMany(mappedBy = "page")
    private Collection<Word> words = Collections.emptyList();
    private ZonedDateTime createdAt = ZonedDateTime.now();

    public PageDto(String url, Collection<Word> words) {
        this.url = url;
        this.words = words;
    }
}
