package com.javarush.module3final.entity;

public class BaseAnswer {
    private String text;
    private Long move;

    public BaseAnswer(String text, Long move) {
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
