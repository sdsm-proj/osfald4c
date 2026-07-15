package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.vuespringsection._VueSpringSectionUtil;
import pl.org.opi.sdsm.app.vuespringsection.model.VueSpringSectionGenModel;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.model.Scenario02Config;

import java.util.Map;

@Slf4j
public abstract class _StepBase {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    protected VueSpringSectionGenModel _getModel() {
        return _VueSpringSectionUtil.getModel();
    }

    protected Scenario02Config _getConfig() {
        return _VueSpringSectionUtil.getModel().getScenario02Model().getConfig();
    }

    protected Map<String, String> _getVars() {
        return _VueSpringSectionUtil.getModel().getScenario02Model().getVars();
    }

    abstract protected void execCore() throws Exception;

}
