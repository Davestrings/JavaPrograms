package filematcher;

import org.junit.jupiter.api.BeforeEach;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileMatcherTest {
    public static void openFiles(){
        try{
            FileWriter file = new FileWriter("trans.txt");

        }catch (IOException ex){
            System.err.println("Error ");
        }
    }
    @BeforeEach
    void setUp() {
    }
}