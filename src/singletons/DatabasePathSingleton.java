package singletons;

public class DatabasePathSingleton {
    private static String path;

    private DatabasePathSingleton(String path) {
        DatabasePathSingleton.path = path;
    }

    public static DatabasePathSingleton getInstance() {
        return DatabasePathSingleton.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final DatabasePathSingleton INSTANCE = new DatabasePathSingleton(path);
    }

    public void setPath(String parsePath) {
        DatabasePathSingleton.path = parsePath;
    }

    public String getPath() {
        return DatabasePathSingleton.path;
    }
}
