package pl.org.opi.util.fileDir;

import java.io.File;

public class FileChooserFilterJson extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        String filename = file.getName();
        return filename.endsWith(".json");
    }

    @Override
    public String getDescription() {
        return "json";
    }

}
