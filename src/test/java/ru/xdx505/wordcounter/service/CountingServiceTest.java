package ru.xdx505.wordcounter.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.BadAttributeValueExpException;
import javax.persistence.EntityNotFoundException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CountingServiceTest {

    @Autowired
    private CountingService countingService;

    private final String TEST_TEXT = "Книга предназначена для управленческого персонала разного уровня и финансово-учетных работников строительных организаций, а также для студентов вузов в качестве учебно-методического материала.";

    @Test
    void checkCorrectCounting() throws BadAttributeValueExpException {
        Map map;
        map = countingService.countWords(TEST_TEXT, 1);//все слова
        assertEquals(22, map.size());
        map = countingService.countWords(TEST_TEXT, 2);//без однобуквенных слов
        assertEquals(19, map.size());
        map = countingService.countWords(TEST_TEXT, 15); //от такой длины только слово "управленческого"
        assertEquals(1, map.size());
    }

    @Test
    void checkExceptions() {
        assertThrows(
                BadAttributeValueExpException.class,
                () -> countingService.countWords(TEST_TEXT, 0),
                "Нет проверки на длину слова менее 0"
        );
        assertThrows(
                BadAttributeValueExpException.class,
                () -> countingService.countWords(TEST_TEXT, 65),
                "Нет проверки на длину слова более 64"
        );
        assertThrows(
                EntityNotFoundException.class,
                () -> countingService.countWords(TEST_TEXT, 60),
                "Должна быть проверка на отсутствие слов длинной больше, чем заявлено"
        );
    }
}
