package ru.xdx505.wordcounter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordResponseDto {
    private String word = StringUtils.EMPTY;
    private int count = 0;
}
