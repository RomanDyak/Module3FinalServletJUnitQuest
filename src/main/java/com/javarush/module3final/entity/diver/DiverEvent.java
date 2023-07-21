package com.javarush.module3final.entity.diver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.Objects.isNull;

public class DiverEvent {
    private static final Logger logger = LoggerFactory.getLogger(DiverAnswer.class);
    private Long id;
    private String text;
    private List<DiverAnswer> actions;

    public DiverEvent(Long id, String text, List<DiverAnswer> actions) {
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
