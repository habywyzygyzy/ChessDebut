package tools;

import java.io.File;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Loading entire folder
 */
public class LoadFolder {

    /**
     * @param path Path to folder
     * @return Array of files inside given folder
     */
    public static File[] loadFolder(String path) {
        File file = new File(path);
        File[] files = new File[0];
        if (file.exists()) {
            files = file.listFiles();
            if ((files == null) || (files.length > 0)) {
                log("empty folder :-(");
            }
        }
        return files;
    }
}