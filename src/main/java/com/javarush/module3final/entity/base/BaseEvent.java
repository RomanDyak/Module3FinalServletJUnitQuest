package com.javarush.module3final.entity.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.Objects.isNull;

public class BaseEvent {
    private static final Logger logger = LoggerFactory.getLogger(BaseAnswer.class);
    private Long id;
    private String text;
    private List<BaseAnswer> actions;

    public BaseEvent(Long id, String text, List<BaseAnswer> actions) {
        if (isNull(id)) {
            logger.error("Id is null");
            throw new IllegalArgumentException("Id param cannot be null.");
        }
        if (isNull(text)) {
            logger.error("Text is null");
            throw new IllegalArgumentException("Text param cannot be null.");
        }
        if (isNull(actions)) {
            logger.error("Actions is null");
            throw new IllegalArgumentException("Actions param cannot be null.");
        }

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
