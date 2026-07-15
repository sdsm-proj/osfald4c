package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.steps;

import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps._StepBase;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;

public class Step2220GenController extends _StepBase {

    @Override
    protected void execCore() throws Exception {
        gen(_getModel().getScenario02Model().getSelectedPartNode());
    }

    private String gen(MetaNode metaNode) {
        String s = "";
        String s1 = "";
        s += "\n";
        s += "\n";
        s += _getConfig().getPakietController();
        s += ".sekcje.";
        s += _getConfig().getPakietSekcji();
        s += ";" + "\n";
        s += "\n";
        s += "import graphql.schema.DataFetchingEnvironment;" + "\n";
        s += "import jakarta.validation.Valid;" + "\n";
        s += "import lombok.RequiredArgsConstructor;" + "\n";
        s += "import lombok.extern.slf4j.Slf4j;" + "\n";
        s += "import org.springframework.graphql.data.method.annotation.Argument;" + "\n";
        s += "import org.springframework.graphql.data.method.annotation.MutationMapping;" + "\n";
        s += "import org.springframework.stereotype.Controller;" + "\n";
        s += "import pl.org.opi.locks.dto.BlokadaInput" + "\n";
        s += "import pl.org.opi.nawa.raport.formularz.v1.controller.dto.wnioskodawca.StatusWnioskodawcyInput;" + "\n";
        s += "import pl.org.opi.nawa.raport.formularz.v1.service.sekcje.wnioskodawca.ZapiszStatusWnioskodawcyService;" + "\n";
        s += "import pl.org.opi.osf.validation.controller.AbstractInputValidatingController;" + "\n";
        s += "" + "\n";
        s += "@Controller" + "\n";
        s += "@Slf4j" + "\n";
        s += "@RequiredArgsConstructor" + "\n";
        s += "" + "\n";
        s1 = "";
        s1 += "public class ";
        s1 += _getConfig().getMutationPrefixDlaDokumentu();
        s1 += _getConfig().getMutationPrefixOperacja();
        s1 += metaNode.getPrefixedSimpleName();
        s1 += "Controller";
        s1 += " extends AbstractInputValidatingController {";
        s += s1 + "\n";
        s += "" + "\n";
        s += "    " + "@MutationMapping" + "\n";

        s1 = "    ";
        s1 += "public String ";
        s1 += _getConfig().getRw();
        s1 += _getConfig().getMutationPrefixDlaDokumentu();
        s1 += _getConfig().getMutationPrefixOperacja();
        s1 += metaNode.getPrefixedSimpleName();
        s1 += "(@Argument BlokadaInput blokada,";
        s += s1 + "\n";

        s1 = "                        ";
        s1 += "@Argument @NotNull ";
        s1 += (_getConfig().isInputOutputWithPrefix() ? metaNode.getPrefixedSimpleName() : metaNode.getFldClassSimpleName()) + "Input";
        s1 += " input,";
        s += s1 + "\n";

        s += "                        " + "DataFetchingEnvironment dataFetchingEnvironment) {" + "\n";




        s += "    }" + "\n";
        s += "}" + "\n";

/*
        s += _getConfig().getMutationPrefixDlaDokumentu();
        s += _getConfig().getMutationPrefixOperacja();
        s += javaNode.getPrefixedSimpleName();
        s += "(";
        if (1 == 1) {
            s += "blokada: BlokadaInput, ";
        }
        s += "input: ";
        s += (_getConfig().isInputOutputWithPrefix() ? javaNode.getPrefixedSimpleName() : javaNode.getFldClassSimpleName()) + "Input";
        s += "): String";
 */

        System.out.println(s);
        return s;
    }

}
