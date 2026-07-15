package pl.org.opi.sdsm.app.vuespringsection.model.parsedproject;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TypeAndCu {
    private TypeDeclaration<?> type;
    private CompilationUnit cu;

    public String getSimpleTypeName() {
        return type.getName().getIdentifier();
    }

    public String getFullTypeName() {
        return cu.getPackageDeclaration().get().getName().toString() + "." + type.getName().getIdentifier();
    }

    public String getPackageName() {
        return cu.getPackageDeclaration().get().getName().toString();
    }

    public boolean doesExtend(String simpleTypeName) {
        if (type instanceof ClassOrInterfaceDeclaration klazz) {
            for(var et: klazz.getExtendedTypes()) {
                if (et.getName().getIdentifier().equals(simpleTypeName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
