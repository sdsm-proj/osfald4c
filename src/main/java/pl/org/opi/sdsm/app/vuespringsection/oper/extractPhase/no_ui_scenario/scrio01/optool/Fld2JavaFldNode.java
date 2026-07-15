package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.optool;

import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.vuespringsection._VueSpringSectionUtil;
import pl.org.opi.sdsm.app.vuespringsection.model.VueSpringSectionGenModel;

@Slf4j

public class Fld2JavaFldNode {

    private final String fldName;

    private final String typePkgName;

    private final ClassOrInterfaceType fldType;

    private JavaFldNode rslt;

    public Fld2JavaFldNode(String fldName, String typePkgName, ClassOrInterfaceType fldType) {
        this.fldName = fldName;
        this.typePkgName = typePkgName;
        this.fldType = fldType;
    }

    protected VueSpringSectionGenModel _getModel() {
        return _VueSpringSectionUtil.getModel();
    }

    public JavaFldNode exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return rslt;
    }

    private void execCore() throws Exception {
        rslt = new JavaFldNode(this.fldName, this.fldType.getName().getIdentifier(), typePkgName, true, false);
        iterateFldsRecur(rslt);
    }

    private void iterateFldsRecur(JavaFldNode node) {
        // Szukaj tcu dla pola
        var parentTcu = _getModel().getParsedProject().findByPkgTypeName(node.getTypePkgName(), node.getFldTypeName());

        if (parentTcu != null) {  // klasa zdefiniowana w aplikacji
            ClassOrInterfaceDeclaration klazz = (ClassOrInterfaceDeclaration) parentTcu.getType();
            for (BodyDeclaration member : klazz.getMembers()) {
                if (member instanceof FieldDeclaration fld) {
                    String _fldName = fld.getVariable(0).getName().getIdentifier();
                    boolean _list = false;

                    var _t = fld.getElementType();

                    String _fldType = "";
                    if (fld.getElementType() instanceof ClassOrInterfaceType cit) {
                        _fldType = cit.getName().getIdentifier();
                    } else {
                        _fldType = fld.getElementType().toString();
                    }
                    String _pkgName = TcuUtil.findPackageInCu(_fldType, parentTcu.getCu());


                    if (_fldType.equals("List")) {
                        if (fld.getElementType() instanceof ClassOrInterfaceType cit) {
                            if (cit.getTypeArguments().isPresent()) {
                                _fldType =  cit.getTypeArguments().get().get(0).getElementType().toString();
                                _pkgName = TcuUtil.findPackageInCu(_fldType, parentTcu.getCu());
                                _list = true;

                                int dbg1 = 1;
                            }
                        }
                    }


                    var fldTcu = _getModel().getParsedProject().findByPkgTypeName(_pkgName, _fldType);

                    // member jest znaną klasą
                    if (fldTcu != null) {
                        JavaFldNode jfn = new JavaFldNode(_fldName, _fldType, _pkgName, true, _list);
                         node.getSubs().add(jfn);

                        iterateFldsRecur(jfn);

                    }
                    // member nie jest znaną klasą
                    else {
                        JavaFldNode jfn = new JavaFldNode(_fldName, _fldType, "", false, _list);
                        node.getSubs().add(jfn);
                    }
                    int dbg1 = 1;
                }
            }

        }
    }


}
