package pl.org.opi.sdsm.frmwk.util.filePathPckg;

import org.apache.commons.lang3.StringUtils;
import pl.org.opi.commons.fileDir.FileDirNormalizeName;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

public class FilePathPckg {

    public static final String SRC_MAIN_JAVA = "src/main/java/";
    public static final String SRC_TEST_JAVA = "src/test/java/";
    
    public static String absolutePath2RelativePath(String path) {
        String abs = FileDirNormalizeName.removeLastElemIfExistingFile(path);
        String absolutePathNorm = FileDirNormalizeName.normalizePathName(abs);
        String rootPath = SdsmCtx.getInstance().getCurrGen().getModel().getPrjRootPath();
        if (!absolutePathNorm.startsWith(rootPath)) {
            throw new OsfaldRuntimeException("Path not within project root path");
        }
        String rel = StringUtils.removeStart(absolutePathNorm, rootPath);
        return rel;
    }
   
    public static String relativePath2Package(String relPath) {
        String s = relPath;
        s = StringUtils.removeStart(s, SRC_MAIN_JAVA);
        s = StringUtils.removeStart(s, SRC_TEST_JAVA);
        String pckg = StringUtils.replace(s, "/", ".");
        pckg = StringUtils.removeStart(pckg, ".");
        pckg = StringUtils.removeEnd(pckg, ".");
        return pckg;
    }
    
}
