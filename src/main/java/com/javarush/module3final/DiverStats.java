package com.javarush.module3final;

import java.util.ArrayList;
import java.util.List;

public class DiverStats {
    private int bodyStat;
    private int fearStat;
    private int heartStat;
    private int coordStat;
    private int feelingStat;

    public DiverStats() {
        this.bodyStat = 4;
        this.fearStat = 4;
        this.heartStat = 4;
        this.coordStat = 4;
        this.feelingStat = 4;
    }

    public void changeStats(List<Integer> change) {
        if(change == null) return;
        this.bodyStat += change.get(0);
        this.fearStat += change.get(1);
        this.heartStat += change.get(2);
        this.coordStat += change.get(3);
        this.feelingStat += change.get(4);


    }

    @Override
    public String toString() {
        return "DiverStats{" +
                "bodyStat=" + bodyStat +
                ", fearStat=" + fearStat +
                ", heartStat=" + heartStat +
                ", coordStat=" + coordStat +
                ", feelingStat=" + feelingStat +
                '}';
    }

    public List<String> getStats() {
        List<String> textStats = new ArrayList<>(5);

        if (this.bodyStat >= 5) {
            textStats.add(0, "Ваша физическая форма идеальна");
        } else if (this.bodyStat == 4) {
            textStats.add(0, "Усталость дает о себе знать");
        } else if (this.bodyStat == 3) {
            textStats.add(0, "Ваше тело ломит и крутит");
        } else if (this.bodyStat == 2) {
            textStats.add(0, "Вы чувствуете, что смертельно устали");
        } else {
            textStats.add(0, "Вы на грани смерти от истощения");
        }

        if (this.fearStat >= 5) {
            textStats.add(1, "Вы спокойны и собраны, как олимпиец");
        } else if (this.fearStat == 4) {
            textStats.add(1, "Вам становится страшно");
        } else if (this.fearStat == 3) {
            textStats.add(1, "Вы начинаете паниковать");
        } else {
            textStats.add(1, "Вам с трудом удается сохранять рассудок");
        }

        if (this.heartStat >= 5) {
            textStats.add(2, "Ваше сердце бьется, как часы");
        } else if (this.heartStat == 4) {
            textStats.add(2, "Работа сердца удовлетворительна");
        } else if (this.heartStat == 3) {
            textStats.add(2, "Начинается явная аритмия сердца");
        } else if (this.heartStat == 2) {
            textStats.add(2, "Ужасно щемит в груди");
        } else {
            textStats.add(2, "Кажется, у вас инфаркт");
        }

        if (this.coordStat >= 5) {
            textStats.add(3, "Ваши действия идеально точны");
        } else {
            textStats.add(3, "Координация дает сбои");
        }

        if (this.feelingStat >= 5) {
            textStats.add(4, "Вы прекрасно чувствуете себя");
        } else if (this.feelingStat == 4) {
            textStats.add(4, "Самочувствие так себе");
        } else if (this.feelingStat == 3) {
            textStats.add(4, "Вам плохо");
        } else {
            textStats.add(4, "Вам так плохо, что лучше умереть");
        }

        return textStats;
    }

    public int getBodyStat() {
        return bodyStat;
    }

    public int getFearStat() {
        return fearStat;
    }

    public int getHeartStat() {
        return heartStat;
    }

    public int getCoordStat() {
        return coordStat;
    }

    public int getFeelingStat() {
        return feelingStat;
    }
}
