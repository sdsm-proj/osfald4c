package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.vuespringsection.model.parsedproject.TypeAndCu;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.Scenario01Model;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.optool.TcuUtil;

@Slf4j
public class Step102WyszukajSekcjeOp extends _StepBase {

    protected void execCore() throws Exception {
        for (TypeAndCu potencjalnyDokumentTcu : _getModel().getScenario01Model().getPotencjalneDokumenty()) {
            szukajSekcji(potencjalnyDokumentTcu);
        }
    }

    private void szukajSekcji(TypeAndCu potencjalnyDokumentTcu) {
        ClassOrInterfaceDeclaration klazz = (ClassOrInterfaceDeclaration) potencjalnyDokumentTcu.getType();
        for (BodyDeclaration member : klazz.getMembers()) {
            if (member instanceof FieldDeclaration fld) {
                if (!fld.getElementType().isPrimitiveType()) {
                    var t = fld.getElementType();
                    if (t instanceof ClassOrInterfaceType t2) {
                        if (_getModel().getParsedProject().existsType(t2.getName().getIdentifier())) {
                            //System.out.println(fld.asFieldDeclaration().getVariable(0).getName().getIdentifier() + " : " + t2.getName().getIdentifier());

                            if (fld.asFieldDeclaration().getVariable(0).getName().getIdentifier().equals("panOsfald")) {

                                String _nazwaPola = fld.asFieldDeclaration().getVariable(0).getName().getIdentifier();
                                ClassOrInterfaceType _typ = t2;
                                //String _pkgName = TcuUtil.findPackageInCu(t2.getName().getIdentifier(), potencjalnyDokumentTcu.getCu());
                                String _pkgName = "";
                                if (t2.getScope().isPresent()) {
                                    _pkgName = t2.getScope().get().toString();
                                }
                                if (StringUtils.isBlank(_pkgName)) {
                                    _pkgName = TcuUtil.findPackageInCu(t2.getName().getIdentifier(), potencjalnyDokumentTcu.getCu());
                                }

                                Scenario01Model.WybranaSekcja ws = new Scenario01Model.WybranaSekcja(
                                        _nazwaPola,
                                        _typ,
                                        _pkgName
                                );
                                _getModel().getScenario01Model().setWybranaSekcja(ws);
                            }
                        }
                    }
                }
            }
        }
    }




}
