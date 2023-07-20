package com.javarush.module3final.entity.diver;

import java.util.Arrays;
import java.util.List;

public class DiverAnswer {
    private String text;
    private Long move;
    private List<Integer> actionResult;

    public DiverAnswer(String text, Long move, List<Integer> actionResult) {
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
