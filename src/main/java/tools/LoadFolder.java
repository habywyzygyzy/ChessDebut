package tools;

import org.supareno.pgnparser.filters.PGNFileFilter;

import java.io.File;

import static com.sun.activation.registries.LogSupport.log;

public class LoadFolder {

    public static File[] loadFolder(String path) {
        File file = new File(path);
        File[] files = new File[0];
        if (file.exists()) {
            files = file.listFiles(new PGNFileFilter());
            if ((files == null) || (files.length > 0)) {
                log("empty folder :-(");
            }
        }
        return files;
    }
}