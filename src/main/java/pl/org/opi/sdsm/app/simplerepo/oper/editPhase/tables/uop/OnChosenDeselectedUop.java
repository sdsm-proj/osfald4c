package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.tables.uop;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.oper.editPhase.tables.op.SelectedFieldClearOp;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnChosenDeselectedUop {
    
    public void exec(EditViewPanel panel) {
        try {
            execCore(panel);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore(EditViewPanel panel) {
        panel.getModelTableTables().getData().clear();
        new SelectedFieldClearOp(panel).exec();
    }
    
}
