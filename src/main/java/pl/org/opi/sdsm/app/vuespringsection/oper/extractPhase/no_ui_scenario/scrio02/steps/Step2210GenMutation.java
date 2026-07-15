package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.steps;

import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps._StepBase;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;

public class Step2210GenMutation extends _StepBase {

    @Override
    protected void execCore() throws Exception {
        gen(_getModel().getScenario02Model().getSelectedPartNode());
    }

    private String gen(MetaNode metaNode) {
        String s = "";
        s += _getConfig().getRw();
        s += _getConfig().getMutationPrefixDlaDokumentu();
        s += _getConfig().getMutationPrefixOperacja();
        s += metaNode.getPrefixedSimpleName();
        s += "(";
        if (1 == 1) {
            s += "blokada: BlokadaInput, ";
        }
        s += "input: ";
        s += (_getConfig().isInputOutputWithPrefix() ? metaNode.getPrefixedSimpleName() : metaNode.getFldClassSimpleName()) + "Input";
        s += "): String";

        System.out.println(s);
        return s;
    }

}
