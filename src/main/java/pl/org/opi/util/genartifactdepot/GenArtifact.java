package pl.org.opi.util.genartifactdepot;

import lombok.Data;

import java.io.File;

@Data
public class GenArtifact {

    public enum EnumFrontBack {
        FRONTEND, BACKEND
    }

    public enum EnumLanguage {
        JAVA, VUE_HTML, VUE_TYPESCRIPT, GRAPH_QL
    }

    public enum EnumFullPart {
        FULL_FILE,
        PART
    }

    private EnumFrontBack frontBack;

    private EnumLanguage language;

    private EnumFullPart fullPart;

    private String artifactDisplayName;

    private String genCode;

    private String genCodeAi;

    private int genCodeLoc;

    private String srcFullPath;

    private File srcFile;

    private boolean alreadyWritten = false;

}
