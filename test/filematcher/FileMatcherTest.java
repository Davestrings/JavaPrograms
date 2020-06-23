package filematcher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;
import java.util.Scanner;

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
    void writeToFileTest(){

    }
}