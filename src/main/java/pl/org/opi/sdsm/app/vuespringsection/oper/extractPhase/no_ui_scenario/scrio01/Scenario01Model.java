package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01;

import com.github.javaparser.ast.type.ClassOrInterfaceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import pl.org.opi.sdsm.app.vuespringsection.model.parsedproject.TypeAndCu;

import java.util.ArrayList;
import java.util.List;

@Data
public class Scenario01Model {

    @Data
    static public class DokumentPlusSekcje {
        private TypeAndCu dokument;
        private List<ClassOrInterfaceType> sekcje = new ArrayList<>();
    }

    @AllArgsConstructor
    @Data
    static public class WybranaSekcja {
        String nazwaPola;
        ClassOrInterfaceType typ;
        String pkgName;
    }

    private List<TypeAndCu> potencjalneDokumenty = new ArrayList<>();

    private List<DokumentPlusSekcje> dokumentyPlusSekcje = new ArrayList<>();

    private WybranaSekcja wybranaSekcja;


}
