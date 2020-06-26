package recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    void checkPower(){
        assertEquals(1, Power.efficientPower(3, 0));
    }
    @Test
    void checkPower2(){
        assertEquals(81, Power.efficientPower(3, 4));
    }
    @Test
    void checkPower3(){
        assertEquals(1, Power.power(3, 0));
    }
    @Test
    void checkPower4(){
        assertEquals(81, Power.power(3, 4));
    }
}