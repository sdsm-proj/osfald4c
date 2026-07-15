package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.optool;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;

public class TcuUtil {

    public static String findPackageInCu(String typeName, CompilationUnit cu) {
        for(ImportDeclaration im: cu.getImports()) {
            String pkgName = im.getNameAsString();
            if (pkgName.endsWith(typeName)) {
                return pkgName.substring(0, (pkgName.length() - typeName.length() - 1));
            }
        }
        return null;
    }

}
