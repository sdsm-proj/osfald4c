package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnChosenQryDeselectedUop {
    
    public void exec(GenerateViewPanel panel) {
        try {
            execCore(panel);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }
    
    private void execCore(GenerateViewPanel panel) {
            panel.getEdQueryClassName().setText("");
            panel.getEdQueryEntityName().setText("");
            panel.getEdQueryPathRel().setText("");

            panel.getEdQueryPathAbs().setText("");
    }
    
}
