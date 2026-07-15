package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps.Step010LadujKlasyOp;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps.Step100WyszukajDokumentyOp;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps.Step102WyszukajSekcjeOp;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps.Step201StrukturaSekcjiOp;

@Slf4j
public class Scenario01 {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() throws Exception {
        new Step010LadujKlasyOp().exec();
        new Step100WyszukajDokumentyOp().exec();
        new Step102WyszukajSekcjeOp().exec();
        new Step201StrukturaSekcjiOp().exec();
    }

}
