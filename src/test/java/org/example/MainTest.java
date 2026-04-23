package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class MainTest {

    @Test
    void testStandardCase() {
        StringBuffer text = new StringBuffer("Це тест? Так, це він. Яке слово підходить?");

        List<String> result = Main.getWordsFromQuestions(text, 4);

        assertEquals(1, result.size());
        assertTrue(result.contains("тест"));
    }

    @Test
    void testNoQuestions() {
        StringBuffer text = new StringBuffer("Просте речення. Ще одне!");
        List<String> result = Main.getWordsFromQuestions(text, 5);


        assertTrue(result.isEmpty());
    }

    @Test
    void testUniqueWords() {
        StringBuffer text = new StringBuffer("Хто тут? Хто тут?");

        List<String> result = Main.getWordsFromQuestions(text, 3);


        assertEquals(2, result.size());
        assertTrue(result.contains("хто"));
        assertTrue(result.contains("тут"));
    }
}