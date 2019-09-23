package singletons;

/**
 * Singleton that holds filters added by user
 */
public class FiltersSingleton {

    private static String name;
    private static String opening;
    private static int year;
    private static int minELO;
    private static int maxELO;

    /**
     * @param name    Name of player
     * @param opening Used opening
     * @param year    Minimum year
     * @param minELO  Minimum ELO of a player
     * @param maxELO  Maximum ELO of a player
     */
    private FiltersSingleton(String name, String opening, int year, int minELO, int maxELO) {
        FiltersSingleton.name = name;
        FiltersSingleton.opening = opening;
        FiltersSingleton.year = year;
        FiltersSingleton.minELO = minELO;
        FiltersSingleton.maxELO = maxELO;
    }

    public static FiltersSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Class that holds the instance of singleton
     */
    private static class SingletonHolder {
        private static final FiltersSingleton INSTANCE = new FiltersSingleton(name, opening, year, minELO, maxELO);
    }

    public static String getName() {
        return FiltersSingleton.name;
    }

    public static void setName(String name) {
        FiltersSingleton.name = name;
    }

    public static String getOpening() {
        return FiltersSingleton.opening;
    }

    public static void setOpening(String opening) {
        FiltersSingleton.opening = opening;
    }

    public static int getYear() {
        return FiltersSingleton.year;
    }

    public static void setYear(int year) {
        FiltersSingleton.year = year;
    }

    public static int getMinELO() {
        return FiltersSingleton.minELO;
    }

    public static void setMinELO(int minELO) {
        FiltersSingleton.minELO = minELO;
    }

    public static int getMaxELO() {
        return FiltersSingleton.maxELO;
    }

    public static void setMaxELO(int maxELO) {
        FiltersSingleton.maxELO = maxELO;
    }
}
