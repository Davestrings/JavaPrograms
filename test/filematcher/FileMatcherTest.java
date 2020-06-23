package filematcher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileMatcherTest {


    @BeforeEach
    void setUp() {
    }
    @Test
    void fileTest(){
        Path path = Paths.get("trans.txt");
        assertFalse(Files.exists(path));
    }
    @Test
    void fileTest2(){
        Path path = Paths.get("oldmast.txt");
        assertTrue(Files.exists(path));
    }
    @Test
    void acceptOnlyValidPathTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            Main.createFile("afile");
        });
        String expectedMessage = "Path should have a (.) extension";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void throwNullPointerExceptionForNullValue(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            Main.createFile(null);
        });
        String expectedMessage = "Null value not accepted";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void writeToFileTest(){

    }
}