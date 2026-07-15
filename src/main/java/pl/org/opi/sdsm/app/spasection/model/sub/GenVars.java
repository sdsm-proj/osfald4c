package pl.org.opi.sdsm.app.spasection.model.sub;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GenVars {

    @Data
    static public class JavaClassDef {
        private String fullPackage;
        private String simpleClass;
        private String fullClass;
        private String fullFileName;
    }

    private String javaInputFullPackage;
    private List<JavaClassDef> javaInputClassDefs = new ArrayList<>();
    private String javaOutputFullPackage;
    private List<JavaClassDef> javaOutputClassDefs = new ArrayList<>();
    private JavaClassDef javaServiceIfaceClassDef = new JavaClassDef();
    private JavaClassDef javaServiceImplClassDef = new JavaClassDef();
    private JavaClassDef javaControllerClassDef = new JavaClassDef();
    private String javaControllerMethodName;
    private String javaMapperFullPackage;
    private JavaClassDef javaInputMapper = new JavaClassDef();
    private JavaClassDef javaOutputMapper = new JavaClassDef();

}
