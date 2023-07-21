package com.javarush.module3final.entity.diver;

import com.javarush.module3final.DiverLogicServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;

public class DiverAnswer {
    private static final Logger logger = LoggerFactory.getLogger(DiverAnswer.class);
    private String text;
    private Long move;
    private List<Integer> actionResult;

    public DiverAnswer(String text, Long move, List<Integer> actionResult) {
        if (isNull(text)) {
            logger.error("text is null");
            throw new IllegalArgumentException("Text param cannot be null.");
        }
        if (isNull(move)) {
            logger.error("move is null");
            throw new IllegalArgumentException("Move param cannot be null.");
        }
        if (isNull(actionResult)) {
            logger.error("actionResult is null");
            throw new IllegalArgumentException("ActionResult param cannot be null.");
        }

        this.text = text;
        this.move = move;
        this.actionResult = actionResult;
    }

    public String getText() {
        return text;
    }

    public Long getMove() {
        return move;
    }

    public List<Integer> getActionResult() {
        return actionResult;
    }

}
