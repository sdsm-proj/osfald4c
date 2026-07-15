package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.vuespringsection._VueSpringSectionUtil;
import pl.org.opi.sdsm.app.vuespringsection.model.VueSpringSectionGenModel;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.steps.*;

@Slf4j
public class Scenario02 {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() throws Exception {
//        new GraphQlParse().exec();

        brejk();
        new Step2010LadujKlasy().exec();
        brejk();
        new Step2020WyszukajDokumenty().exec();
        brejk();
        new Step2030WyszukajSekcje().exec();
        brejk();
        new Step2110GenInputOutputGraphQL(EnumInOut.OUTPUT).exec();
        brejk();
        new Step2110GenInputOutputGraphQL(EnumInOut.INPUT).exec();
        brejk();
        new Step2120GenInputOutputJava(EnumInOut.OUTPUT).exec();
        brejk();
        new Step2120GenInputOutputJava(EnumInOut.INPUT).exec();
        brejk();
        new Step2210GenMutation().exec();
        brejk();
        new Step2220GenController().exec();
        brejk();
        new Step2310GenServiceIface().exec();
        brejk();
        new Step2320GenServiceImpl().exec();
        brejk();

    }

    private VueSpringSectionGenModel _getModel() {
        return _VueSpringSectionUtil.getModel();
    }

    private void brejk() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        showVars();
        System.out.println();
    }

    private void showVars() {
        for(var elem: _getModel().getScenario02Model().getVars().entrySet()) {
            System.out.println("[" + elem.getKey() + "] : " + elem.getValue());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

}
