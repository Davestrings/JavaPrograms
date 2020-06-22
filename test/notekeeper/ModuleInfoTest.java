package notekeeper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModuleInfoTest {
    ModuleInfo module;
    @BeforeEach
    void setUp() {
        module = new ModuleInfo("Java Lang", "Iteration in Java");
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void setModuleIdTest(){
        module.setmModuleId("Java");
        assertEquals("Java", module.getmModuleId());
    }
    @Test
    void setModuleIdWithDigitTest(){
        module.setmModuleId("12");
        assertEquals("12", module.getmModuleId());
    }
    @Test
    void setModuleTitleTest(){
        module.setmModuleTitle("Django");
        assertEquals("Django", module.getmModuleTitle());
    }
    @Test
    void setModuleTitleWithDigitTest(){
        module.setmModuleTitle("2");
        assertEquals("2", module.getmModuleTitle());
    }
}