package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.optool.Fld2JavaFldNode;

@Slf4j
public class Step201StrukturaSekcjiOp extends _StepBase {

    protected void execCore() throws Exception {
        Fld2JavaFldNode op = new Fld2JavaFldNode(
                _getModel().getScenario01Model().getWybranaSekcja().getNazwaPola(),
                _getModel().getScenario01Model().getWybranaSekcja().getPkgName(),
                _getModel().getScenario01Model().getWybranaSekcja().getTyp()
        );

        var node = op.exec();
        node.show();
    }

}
