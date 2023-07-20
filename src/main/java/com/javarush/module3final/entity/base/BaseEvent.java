package com.javarush.module3final.entity.base;

import java.util.List;

public class BaseEvent {
    private Long id;
    private String text;
    private List<BaseAnswer> actions;

    public BaseEvent(Long id, String text, List<BaseAnswer> actions) {
        this.id = id;
        this.text = text;
        this.actions = actions;
    }
    public String getText() {
        return text;
    }
    public List<BaseAnswer> getActions() {
        return actions;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BaseEvent{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", actions=" + actions +
                '}';
    }
}
