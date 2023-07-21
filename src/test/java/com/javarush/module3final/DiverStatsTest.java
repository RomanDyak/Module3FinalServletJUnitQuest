package com.javarush.module3final;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DiverStatsTest {

    DiverStats diverStats = new DiverStats();

    @Test
    void changeStats() {
        DiverStats diverStatsToChange = new DiverStats();
        diverStatsToChange.changeStats(Arrays.asList(1,-1,1,-1,1));
        assertEquals(5, (diverStatsToChange.getBodyStat()));
        assertEquals(3, (diverStatsToChange.getFearStat()));
        assertEquals(5, (diverStatsToChange.getHeartStat()));
        assertEquals(3, (diverStatsToChange.getCoordStat()));
        assertEquals(5, (diverStatsToChange.getFeelingStat()));
    }

    @Test
    void changeStatsOutOfLimitTest() {
        DiverStats diverStatsToChange = new DiverStats();
        diverStatsToChange.changeStats(Arrays.asList(5,6,7,8,9));

        assertEquals(5, (diverStatsToChange.getBodyStat()));
        assertEquals(5, (diverStatsToChange.getFearStat()));
        assertEquals(5, (diverStatsToChange.getHeartStat()));
        assertEquals(5, (diverStatsToChange.getCoordStat()));
        assertEquals(5, (diverStatsToChange.getFeelingStat()));

        diverStatsToChange.changeStats(Arrays.asList(-15,-16,-17,-18,-19));

        assertEquals(1, (diverStatsToChange.getBodyStat()));
        assertEquals(1, (diverStatsToChange.getFearStat()));
        assertEquals(1, (diverStatsToChange.getHeartStat()));
        assertEquals(1, (diverStatsToChange.getCoordStat()));
        assertEquals(1, (diverStatsToChange.getFeelingStat()));
    }

    @Test
    void getBodyStat() {
        assertEquals(4, (diverStats.getBodyStat()));
    }

    @Test
    void getFearStat() {
        assertEquals(4, (diverStats.getFearStat()));
    }

    @Test
    void getHeartStat() {
        assertEquals(4, (diverStats.getHeartStat()));
    }

    @Test
    void getCoordStat() {
        assertEquals(4, (diverStats.getCoordStat()));
    }

    @Test
    void getFeelingStat() {
        assertEquals(4, (diverStats.getFeelingStat()));
    }
}