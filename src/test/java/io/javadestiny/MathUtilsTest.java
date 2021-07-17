package io.javadestiny;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    void beforeAllInit(){
        System.out.println("This is need to runs before all.");
    }

    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup(){
        System.out.println("Cleaning up...");
    }

    @AfterAll
    void cleanAll(){
        System.out.println("All Cleared.");
    }

    @Test
    @DisplayName("Testing add method")
    void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual, "The add method should add two numbers.");
    }

    @Test
    void testDiv(){
        boolean isServerUp = true;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.div(1, 0), "Divide by zero should throw error.");
    }


    @Test
    @DisplayName("Multiply method")
    void testMul(){
        assertAll(
                () -> assertEquals(4, mathUtils.mul(2,2),"Should return right product"),
                () -> assertEquals(0, mathUtils.mul(2,0),"Should return Zero"),
                () -> assertEquals(-2, mathUtils.mul(-2,1),"Should return negative product")
        );
    }

    @Test
    void testCircleRadius(){
        assertEquals(314.0, mathUtils.computeCircleArea(10),"Should return right circle area.");
    }

    @Test
    @Disabled
    @DisplayName("This test disabled")
    void testDisabled(){
        fail("This test should be disabled");
    }
}
