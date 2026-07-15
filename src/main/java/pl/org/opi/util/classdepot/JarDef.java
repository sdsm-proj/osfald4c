package pl.org.opi.util.classdepot;

import lombok.Getter;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

import java.io.File;

public class JarDef {

    private final String jarFullPath;

    @Getter
    private File fileJar;

    public JarDef(String _jarFullPath) throws Exception {
        this.jarFullPath = _jarFullPath;
        init();
    }

    private void init() throws Exception {
        fileJar = new File(jarFullPath);
        if (!fileJar.exists()) {
            throw new OsfaldRuntimeException("File: " + jarFullPath + " does not exist");
        }
    }
}
