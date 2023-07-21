package com.javarush.module3final.entity.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseAnswerTest {

    @Test
    void constructorNullAndMessageFirstParamTextTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new BaseAnswer(null, 1L);
                });
        assertEquals("Text param cannot be null.", exception.getMessage());
    }

    @Test
    void constructorNullAndMessageSecondParamMoveTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new BaseAnswer("some text", null);
                });
        assertEquals("Move param cannot be blank.", exception.getMessage());
    }
    @Test
    void getText() {
        assertEquals("some text", (new BaseAnswer("some text", 1L)).getText());
    }

    @Test
    void getMove() {
        assertEquals(15L, (new BaseAnswer("some text", 15L)).getMove());
    }
}