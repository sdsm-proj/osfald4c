package pl.org.opi.commons.fileDir;

import javax.swing.*;

public class FileChooserUtils {

    private static String lastSelectedPath;

    public static void setLastSelectedPath(String path) {
        lastSelectedPath = path;
    }

    public static void setLastSelectedPath(JFileChooser fileChooser) {
        if (fileChooser != null) {
            if (fileChooser.getSelectedFile() != null) {
                lastSelectedPath = fileChooser.getSelectedFile().getAbsolutePath();
            } else if (fileChooser.getCurrentDirectory() != null) {
                lastSelectedPath = fileChooser.getCurrentDirectory().getAbsolutePath();
            }
        }
    }

    public static String getLastSelectedPath() {
        if (lastSelectedPath == null) {
            return "";
        } else {
            return lastSelectedPath.trim();
        }
    }

    public static String addExtensionIfNeeded(String fileName, String ext) {
        if (fileName.endsWith(ext)) {
            return fileName;
        } else {
            return fileName + "." + ext;
        }
    }

}
