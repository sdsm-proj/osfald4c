package pl.org.opi.commons.fileDir;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class FileDirCommon {

    public static final String UTF_8 = "UTF-8";
    public static final String DOT = ".";
    public static final String EXT_JSON = "json";

    public static final String SLASH = "/";
    public static final String BACKSLASH = "\\";

    public static String getFileExtension(String fullFileName) {
        return FilenameUtils.getExtension(fullFileName);
    }

    public static boolean fileExists(String fullFileName) {
        File f = new File(fullFileName);
        return f.exists() && !f.isDirectory();
    }

}
