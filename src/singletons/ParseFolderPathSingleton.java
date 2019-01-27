package singletons;

import java.io.File;

public class ParseFolderPathSingleton {
    private static File[] files;

    private ParseFolderPathSingleton(File[] files) {
        ParseFolderPathSingleton.files = files;
    }

    public static ParseFolderPathSingleton getInstance() {
        return ParseFolderPathSingleton.SingletonHolder.INSTANCE;
    }

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
