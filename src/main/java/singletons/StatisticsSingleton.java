package singletons;

import models.Statistics;

import java.util.ArrayList;

/**
 * Singleton that holds calculated statisctics
 */
public class StatisticsSingleton {

    private static ArrayList<Statistics> stats;

    /**
     * @param stats List of statisctics that will be displayed in GUI
     */
    private StatisticsSingleton(ArrayList<Statistics> stats) {
        StatisticsSingleton.stats = stats;
    }

    public static StatisticsSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Class that holds the instance of singleton
     */
    private static class SingletonHolder {
        private static final StatisticsSingleton INSTANCE = new StatisticsSingleton(stats);
    }

    public static ArrayList<Statistics> getStats() {
        return StatisticsSingleton.stats;
    }

    public static void setStats(ArrayList<Statistics> stats) {
        StatisticsSingleton.stats = stats;
    }
}
