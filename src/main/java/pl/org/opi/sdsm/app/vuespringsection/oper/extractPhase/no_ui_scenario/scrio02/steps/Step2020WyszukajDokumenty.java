package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.steps;

import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps._StepBase;

public class Step2020WyszukajDokumenty extends _StepBase {

    @Override
    protected void execCore() throws Exception {
        var dokumenty = _getModel().getScenario02Model().getClassDepot().wyszukajDokumenty();
        _getModel().getScenario02Model().setDokumentCux(dokumenty.get(0));
    }

}
