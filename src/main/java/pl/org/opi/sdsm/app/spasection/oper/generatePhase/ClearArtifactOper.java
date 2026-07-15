package pl.org.opi.sdsm.app.spasection.oper.generatePhase;

import pl.org.opi.sdsm.app.spasection.stru.generatePhase.ui.GenerateViewPanel;

public class ClearArtifactOper {

    private final GenerateViewPanel viewPanel;

    public ClearArtifactOper(GenerateViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() {
        viewPanel.getTextPane1().setText("");
        viewPanel.getTextPane2().setText("");
        viewPanel.getTextPane3().setText("");
    }

}
