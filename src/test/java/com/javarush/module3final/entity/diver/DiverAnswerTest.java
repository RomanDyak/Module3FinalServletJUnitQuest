package com.javarush.module3final.entity.diver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiverAnswerTest {

    @Test
    void constructorNullAndMessageFirstParamTextTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new DiverAnswer(null, 1L, Arrays.asList(1,2,3,4,5));
                });
        assertEquals("Text param cannot be null.", exception.getMessage());
    }

    @Test
    void constructorNullAndMessageSecondParamMoveTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new DiverAnswer("some text", null, Arrays.asList(1,2,3,4,5));
                });
        assertEquals("Move param cannot be null.", exception.getMessage());
    }

    @Test
    void constructorNullAndMessageThirdParamActionResultTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new DiverAnswer("some text", 15L, null);
                });
        assertEquals("ActionResult param cannot be null.", exception.getMessage());
    }

    @Test
    void constructorThirdParamActionResultCorrectSizeTest() {
        assertEquals(5, (new DiverAnswer("some text", 1L, Arrays.asList(1,2,3,4,5))).getActionResult().size());
    }
    @Test
    void getText() {
        assertEquals("some text", (new DiverAnswer("some text", 1L, Arrays.asList(1,2,3,4,5))).getText());
    }

    @Test
    void getMove() {
        assertEquals(15L, (new DiverAnswer("some text", 15L, Arrays.asList(1,2,3,4,5))).getMove());
    }

    @Test
    void getActionResult() {
        List<Integer> testList = Arrays.asList(1,2,3,4,5);
        DiverAnswer diverAnswer = new DiverAnswer("some text", 15L, testList);
        assertIterableEquals(testList, diverAnswer.getActionResult());
    }
}