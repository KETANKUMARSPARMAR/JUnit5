package io.javadestiny;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
public class MathUtilsTest {
    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    void beforeAllInit(){
        System.out.println("This is need to runs before all.");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running "+testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }

    @AfterEach
    void cleanup(){
        System.out.println("Cleaning up...");
    }

    @AfterAll
    void cleanAll(){
        System.out.println("All Cleared.");
    }

    @Nested
    @DisplayName("Add method")
    @Tag("Math")
    class AddTest {
        @Test
        @DisplayName("Testing add method for positive")
        void testAddPositive() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual, "The add method should add two positive numbers.");
        }

        @Test
        @DisplayName("Testing add method for negative")
        void testAddNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            assertEquals(expected, actual, "The add method should add two  negative numbers.");
        }
    }

    @Test
    void testDiv(){
        boolean isServerUp = true;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.div(1, 0), "Divide by zero should throw error.");
    }


    @Test
    @Tag("Math")
    @DisplayName("Multiply method")
    void testMul(){
        //System.out.println("Running "+testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        testReporter.publishEntry("Running "+testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        assertAll(
                () -> assertEquals(4, mathUtils.mul(2,2),"Should return right product"),
                () -> assertEquals(0, mathUtils.mul(2,0),"Should return Zero"),
                () -> assertEquals(-2, mathUtils.mul(-2,1),"Should return negative product")
        );
    }

    @RepeatedTest(3)
    @Tag("Circle")
    void testCircleRadius(RepetitionInfo repetitionInfo){
        int repetition = repetitionInfo.getCurrentRepetition();
        if(repetition == 1){
            System.out.println("First repetition");
        }
        assertEquals(314.0, mathUtils.computeCircleArea(10),"Should return right circle area.");
    }

    @Test
    @Disabled
    @DisplayName("This test disabled")
    void testDisabled(){
        fail("This test should be disabled");
    }
}
