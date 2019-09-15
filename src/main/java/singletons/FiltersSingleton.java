package singletons;

public class FiltersSingleton {

    private static String name;
    private static String opening;
    private static int year;
    private static int minELO;
    private static int maxELO;

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
