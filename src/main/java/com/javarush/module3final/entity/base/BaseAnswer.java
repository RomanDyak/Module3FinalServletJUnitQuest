package com.javarush.module3final.entity.base;

import com.javarush.module3final.DiverLogicServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.isNull;

public class BaseAnswer {

    private static final Logger logger = LoggerFactory.getLogger(DiverLogicServlet.class);
    private String text;
    private Long move;

    public BaseAnswer(String text, Long move) {
        if (isNull(text) || isNull(move)) {
            if(isNull(text)) logger.error("Text in BaseAnswer is null");
            if(isNull(move)) logger.error("move in BaseAnswer is null");
            throw new IllegalArgumentException("BaseAnswer params is null");
        }
        this.text = text;
        this.move = move;
    }

    public String getText() {
        return text;
    }

    public Long getMove() {
        return move;
    }

    @Override
    public String toString() {
        return "BaseAnswer{" +
                "text='" + text + '\'' +
                ", move=" + move +
                '}';
    }
}
