package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Step100WyszukajDokumentyOp extends _StepBase {

    protected void execCore() throws Exception {
        for (var tcu : _getModel().getParsedProject().getTcuMap().values()) {
            if (tcu.doesExtend("AbstractDokumentBase")) {
                //System.out.println(tcu.getFullTypeName());
                //System.out.println(tcu.getSimpleTypeName());
                //System.out.println("");
                _getModel().getScenario01Model().getPotencjalneDokumenty().add(tcu);
            }
        }
    }

}
