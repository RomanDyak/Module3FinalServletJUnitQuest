package com.javarush.module3final.entity.base;

import com.javarush.module3final.DiverLogicServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.isNull;

public class BaseAnswer {

    private static final Logger logger = LoggerFactory.getLogger(BaseAnswer.class);
    private String text;
    private Long move;

    public BaseAnswer(String text, Long move) {

        if (isNull(text)) {
            logger.error("text is null");
            throw new IllegalArgumentException("Text param cannot be null.");
        }
        if (isNull(move)) {
            logger.error("move is blank");
            throw new IllegalArgumentException("Move param cannot be blank.");
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
