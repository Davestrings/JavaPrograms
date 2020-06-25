package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LettersCountTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    void countLetter(){
        //Use this test to run perform the count
        String word = "Hello There";
        List<String> letterList = LettersCount.convertToList(word);
        Map<String, Integer> wordMap = LettersCount.createMap(letterList);
        LettersCount.displayCount(wordMap);
    }
    @Test
    void convertToListTest(){
        String word = "Hello There";
        List<String> letterList = LettersCount.convertToList(word);
        assertFalse(letterList.contains(" "));
    }
    @Test
    void wordIsUpperTest(){
        String word = "Hello There";
        List<String> letterList = LettersCount.convertToList(word);
        assertEquals("H", letterList.get(0));
    }
}