package com.javarush.module3final.entity.base;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseEventTest {

    @Test
    void constructorNullAndMessageFirstParamIdTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new BaseEvent(null, "some text" , Arrays.asList(new BaseAnswer("test", 5L)));
                });
        assertEquals("Id param cannot be null.", exception.getMessage());
    }

    @Test
    void constructorNullAndMessageSecondParamTextTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new BaseEvent(100L, null , Arrays.asList(new BaseAnswer("test", 5L)));
                });
        assertEquals("Text param cannot be null.", exception.getMessage());
    }

    @Test
    void constructorNullAndMessageThirdParamActionsTest() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    new BaseEvent(100L, "text" , null);
                });
        assertEquals("Actions param cannot be null.", exception.getMessage());
    }

    @Test
    void getText() {
        assertEquals("some text", (new BaseEvent(
                1L,"some text", Arrays.asList(new BaseAnswer("test", 5L)))).getText());
    }

    @Test
    void getActions() {
        List<BaseAnswer> baseAnswerList = Arrays.asList(new BaseAnswer("test", 5L));
        assertIterableEquals(baseAnswerList,
                (new BaseEvent(
                10L,"some text", baseAnswerList)).getActions());
    }

    @Test
    void getId() {
        assertEquals(10L, (new BaseEvent(
                10L,"some text", Arrays.asList(new BaseAnswer("test", 5L)))).getId());
    }
}