package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.uop;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnChosenDeselectedUop {
    
    public void exec(GenerateViewPanel panel) {
        try {
            execCore(panel);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }
    
    private void execCore(GenerateViewPanel panel) {
        panel.getEdEntityClassName().setText("");
        panel.getEdEntityPathAbs().setText("");
        panel.getEdEntityPathRel().setText("");
        panel.getEdRepositoryClassName().setText("");
        panel.getEdRepositoryPathAbs().setText("");
        panel.getEdRepositoryPathRel().setText("");
        panel.getEdTestClassName().setText("");
        panel.getEdTestPathAbs().setText("");
        panel.getEdTestPathRel().setText("");
    }
    
}
