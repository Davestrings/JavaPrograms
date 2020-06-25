package filematcher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;
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
        assertFalse(Files.exists(path));
    }
    @Test
    void acceptOnlyValidPathTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            Main.createFile("afile", false);
        });
        String expectedMessage = "Path should have a (.) extension";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void throwNullPointerExceptionForNullValue(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            Main.createFile(null, false);
        });
        String expectedMessage = "Null value not accepted";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void openfileThrowsNullExceptionForNullValue(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            FileMatcher.openFile(null);
        });
        String expectedMessage = "File cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void openFileValidPathTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            FileMatcher.openFile("afile");
        });
        String expectedMessage = "Invalid input. Add file extension";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
//    @Test
//    void openFileValidPathExistTest(){
//        Exception exception = assertThrows(FileNotFoundException.class, () ->{
//            FileMatcher.openFile("file.txt");
//        });
//        String expectedMessage = "File does not exist";
//        String actualMessage = exception.getMessage();
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
    @Test
    void accountCombineMethodTest(){
        Account account = new Account("Alan", "Jones", 100, 348.17);
        TransactionRecord record = new TransactionRecord(100, 27.14);
        assertEquals(375.31, account.combine(record));
    }
    @Test
    void doesFileExist(){
        assertFalse(FileMatcher.doesFileExist("afile.txt"));
    }
    @Test
    void fileDoesExist(){
        assertTrue(FileMatcher.doesFileExist("file.txt"));
    }
    @Test
    void writeFileMethodTest(){
        Account account = new Account("Alan", "Jones", 100, 348.17);
        Main.createFile("file.txt", false);
        FileMatcher.logFile();
        FileMatcher.writeLog(account);
    }
}