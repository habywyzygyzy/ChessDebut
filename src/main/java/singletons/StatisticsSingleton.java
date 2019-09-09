package singletons;

import models.Statistics;

import java.util.ArrayList;

public class StatisticsSingleton {

    private static ArrayList<Statistics> stats;

    private StatisticsSingleton(ArrayList<Statistics> stats) {
        StatisticsSingleton.stats = stats;
    }

    public static StatisticsSingleton getInstance() {
        return StatisticsSingleton.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final StatisticsSingleton INSTANCE = new StatisticsSingleton(stats);
    }

    public static ArrayList<Statistics> getStats() {
        return stats;
    }

    public static void setStats(ArrayList<Statistics> stats) {
        StatisticsSingleton.stats = stats;
    }

}
