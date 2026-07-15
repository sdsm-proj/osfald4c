package pl.org.opi.util.classdepot;

import lombok.Getter;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SourceTargetDef {

    private final String rootPrjPath;
    private final String sourceSubPath;
    private final String targetSubPath;
    private final String[] lookForClassesSubPath;

    @Getter
    private File fileSourceFullPath;
    @Getter
    private File fileTargetFullPath;

    @Getter
    private List<File> fileJavaSubPath = new ArrayList<>();
    @Getter
    private List<File> fileClassesSubPath = new ArrayList<>();

    public SourceTargetDef(String rootPrjPath, String sourceSubPath, String targetSubPath, String[] lookForClassesSubPath) throws Exception {
        this.rootPrjPath = rootPrjPath;
        this.sourceSubPath = sourceSubPath;
        this.targetSubPath = targetSubPath;
        this.lookForClassesSubPath = lookForClassesSubPath;
        init();
    }

    private void init() throws Exception {
        File f;
        String p;

        // Root folder of project
        // "C:\\ncn\\osf-ncn-nawa-back\\"
        f = new File(rootPrjPath);
        if (!f.exists()) {
            throw new OsfaldRuntimeException("Path: " + rootPrjPath + " does not exist");
        }

        // Sub path to java files
        // "src/main/java"
        p = f.getAbsolutePath() + "/" + sourceSubPath;
        fileSourceFullPath = new File(p);
        if (!fileSourceFullPath.exists()) {
            throw new OsfaldRuntimeException("Path: " + p + " does not exist");
        }

        // Sub path to classes files
        // "target\\classes"
        p = f.getAbsolutePath() + "/" + targetSubPath;
        fileTargetFullPath = new File(p);
        if (!fileTargetFullPath.exists()) {
            throw new OsfaldRuntimeException("Path: " + p + " does not exist");
        }

        // Folder of processed classes
        // pl\org\opi\nawa\raport\formularz\v1\model

        for(String subPath: lookForClassesSubPath) {
            p = fileSourceFullPath.getAbsolutePath() + "/" + subPath;
            f = new File(p);
            if (!f.exists()) {
                throw new OsfaldRuntimeException("Path: " + p + " does not exist");
            } else {
                fileJavaSubPath.add(f);
            }
        }

        // Folder of processed classes
        // pl\org\opi\nawa\raport\formularz\v1\model
        for(String subPath: lookForClassesSubPath) {
            p = fileTargetFullPath.getAbsolutePath() + "/" + subPath;
            f = new File(p);
            if (!f.exists()) {
                throw new OsfaldRuntimeException("Path: " + p + " does not exist");
            } else {
                fileClassesSubPath.add(f);
            }
        }



        int dbg = 1;
    }

}
