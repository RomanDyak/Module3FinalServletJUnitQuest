package com.javarush.module3final.entity.diver;

import java.util.List;

public class DiverEvent {
    private Long id;
    private String text;
    private List<DiverAnswer> actions;

    public DiverEvent(Long id, String text, List<DiverAnswer> actions) {
        this.id = id;
        this.text = text;
        this.actions = actions;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<DiverAnswer> getActions() {
        return actions;
    }



    @Override
    public String toString() {
        return "DiverEvent{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", actions=" + actions +
                '}';
    }
}
