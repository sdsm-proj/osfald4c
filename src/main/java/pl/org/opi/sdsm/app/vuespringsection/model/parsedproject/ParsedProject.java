package pl.org.opi.sdsm.app.vuespringsection.model.parsedproject;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.TypeDeclaration;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ParsedProject {

    @Getter
    private final Map<String, TypeAndCu> tcuMap = new HashMap<>();

    public void add(TypeDeclaration<?> type, CompilationUnit cu) {
        if (cu.getPackageDeclaration().isPresent()) {
            String typeFullName =  cu.getPackageDeclaration().get().getName().toString() + "." + type.getName().getIdentifier();

            if (typeFullName.endsWith("ulator")) {
                int dbg1 = 1;
            }

            TypeAndCu tuc = tcuMap.get(typeFullName);
            if (tuc != null) {
                throw new OsfaldRuntimeException("Parsing. Duplicate of " + typeFullName);
            }
            tcuMap.put(typeFullName, new TypeAndCu(type, cu));
        } else {
            log.warn("CompilationUnit - no Package Declaration");
        }
    }

    public void showAll() {
        for(var key: tcuMap.keySet()) {
            System.out.println(key);
        }
    }

    public boolean existsType(String simpleTypeName) {
        for(TypeAndCu tcu: tcuMap.values()) {
            if (tcu.getSimpleTypeName().equals(simpleTypeName)) {
                return true;
            }
        }
        return false;
    }

    public TypeAndCu findByPkgTypeName(String pkgName, String typeName) {
        return tcuMap.values().stream().filter(tcu -> (tcu.getPackageName().equals(pkgName) && tcu.getSimpleTypeName().equals(typeName))).findFirst().orElse(null);
    }

}
