package pl.org.opi.sdsm.app.frontenddto.stru.extractPhase.ui;

import java.io.File;

public class FileRender implements Comparable {

    public FileRender(File file) {
        this.file = file;
    }

    private final File file;

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return file.getName();
    }

    @Override
    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }
}
