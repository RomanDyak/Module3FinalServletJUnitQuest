package com.javarush.module3final;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> longList = new ArrayList<>();
        longList.add(2);
        longList.add(7);

        System.out.println(longList.get(0)- longList.get(1));
    }
}
