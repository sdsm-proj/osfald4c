package pl.org.opi.sdsm.app.jsde01.oper.configPhase._tmp;

import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;

public class Sp1PrepareOper {

    public Sp1PrepareOper(StepPanel stepPanel) {
        this.stepPanel = stepPanel;
    }

    private final StepPanel stepPanel;

    public void exec() {
        System.out.println(stepPanel.getTabLabel());
    }

}
