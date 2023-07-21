package com.javarush.module3final.entity.diver;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiverEventTest {

    List<Integer> integerList = Arrays.asList(1, 1, 1, 1, 0);

    @Test
    void constructorNullAndMessageFirstParamIdTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new DiverEvent(null, "some text", Arrays.asList(new DiverAnswer("test", 5L,
                            integerList)));
                });
        assertEquals("Id param cannot be null.", exception.getMessage());
    }

    @Test
    void constructorNullAndMessageSecondParamTextTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new DiverEvent(100L, null, Arrays.asList(new DiverAnswer("test", 5L,
                            integerList)));
                });
        assertEquals("Text param cannot be null.", exception.getMessage());
    }

    @Test
    void constructorNullAndMessageThirdParamActionsTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new DiverEvent(100L, "text", null);
                });
        assertEquals("Actions param cannot be null.", exception.getMessage());
    }

    @Test
    void getText() {
        assertEquals("some text", (new DiverEvent(
                1L, "some text",
                Arrays.asList(new DiverAnswer("test", 5L, integerList))))
                .getText());
    }

    @Test
    void getActions() {
        List<DiverAnswer> diverAnswerList =
                Arrays.asList(new DiverAnswer("test", 5L, integerList));
        assertEquals(diverAnswerList,
                (new DiverEvent(
                        10L, "some text", diverAnswerList)).getActions());
    }

    @Test
    void getId() {
        assertEquals(10L, (new DiverEvent(
                10L, "some text",
                Arrays.asList(new DiverAnswer("test", 5L, integerList)))).getId());
    }
}