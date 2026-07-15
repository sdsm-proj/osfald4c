package pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase.ui;

import lombok.Data;

import java.io.File;

@Data
public class ComboItem {
    private String display;
    private File javaFile;

    public ComboItem(String display) {
        this.display = display;
    }

    public ComboItem(String display, File javaFile) {
        this.display = display;
        this.javaFile = javaFile;
    }

    @Override
    public String toString() {
        return display;
    }

}
