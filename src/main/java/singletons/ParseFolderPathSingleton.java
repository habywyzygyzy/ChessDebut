package singletons;

import java.io.File;

/**
 * Singleton that holds array of files for parsing
 */
public class ParseFolderPathSingleton {
    private static File[] files;

    /**
     * @param files Array of files from selected folder that will be parsed
     */
    private ParseFolderPathSingleton(File[] files) {
        ParseFolderPathSingleton.files = files;
    }

    public static ParseFolderPathSingleton getInstance() {
        return ParseFolderPathSingleton.SingletonHolder.INSTANCE;
    }

    /**
     * Class that holds the instance of singleton
     */
    private static class SingletonHolder {
        private static final ParseFolderPathSingleton INSTANCE = new ParseFolderPathSingleton(files);
    }

    public void setFiles(File[] files) {
        ParseFolderPathSingleton.files = files;
    }

    public File[] getFiles() {
        return ParseFolderPathSingleton.files;
    }
}
