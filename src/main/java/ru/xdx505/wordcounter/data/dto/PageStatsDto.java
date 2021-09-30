package ru.xdx505.wordcounter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageStatsDto {
    private String url = StringUtils.EMPTY;
    private ZonedDateTime createdAt = ZonedDateTime.now();
    private int uniqueWordsCount = 0;
}
