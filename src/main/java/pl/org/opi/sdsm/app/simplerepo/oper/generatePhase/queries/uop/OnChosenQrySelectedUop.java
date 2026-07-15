package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanelTransfer;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnChosenQrySelectedUop {
    
    public void exec(GenerateViewPanel panel, String tableName) {
        try {
            execCore(panel, tableName);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }
    
    private void execCore(GenerateViewPanel panel, String tableName) {
        panel.getEdQueryPathAbs().setText("");
        new GenerateViewPanelTransfer(panel).model2Ui();
    }
    
}
