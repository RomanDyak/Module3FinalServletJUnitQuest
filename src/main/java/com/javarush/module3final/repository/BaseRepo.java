package com.javarush.module3final.repository;

import com.javarush.module3final.entity.base.BaseAnswer;
import com.javarush.module3final.entity.base.BaseEvent;

import java.util.*;

public class BaseRepo {
    private List<BaseEvent> storage = new ArrayList<>() {{
        add(new BaseEvent(1L,"Здесь должна быть какая-то предыстория, но поскольку скрин практически не читаемый предположим, " +
                "что там произошло что-то интересное, связанное с космосом, Илоном Маском или просто была грандиозная гулянка." +
                "<br>Ты потерял память.<br>Принять вызов НЛО?", new ArrayList<>(Arrays.asList(
                new BaseAnswer("Принять вызов",2L),
                new BaseAnswer("Отклонить вызов",7L))
        )));
        add(new BaseEvent(2L,"Ты принял вызов.<br>Поднимешься на мостик к капитану?", new ArrayList<>(Arrays.asList(
                new BaseAnswer("Подняться на мостик",3L),
                new BaseAnswer("Отказаться подниматься на мостик",6L))
        )));
        add(new BaseEvent(3L,"Ты поднялся на мостик.<br>Ты кто?", new ArrayList<>(Arrays.asList(
                new BaseAnswer("Рассказать правду о себе",4L),
                new BaseAnswer("Солгать о себе",5L))
        )));
        add(new BaseEvent(4L,"Тебя вернули домой.<br>Победа!", new ArrayList<>()));
        add(new BaseEvent(5L,"Твою ложь разоблачили.<br>Поражение!", new ArrayList<>()));
        add(new BaseEvent(6L,"Ты не пошел на переговоры.<br>Поражение!", new ArrayList<>()));
        add(new BaseEvent(7L,"Ты отклонил вызов.<br>Поражение!", new ArrayList<>()));
    }};

    public int getSize() {
        return storage.size();
    }

    public BaseEvent getEvent(Long id) {
        for (BaseEvent event: storage) {
            if(event.getId().equals(id)) return event;
        }
        return null;
    }

    @Override
    public String toString() {
        return "BaseRepo{" +
                "storage=" + storage +
                '}';
    }
}
