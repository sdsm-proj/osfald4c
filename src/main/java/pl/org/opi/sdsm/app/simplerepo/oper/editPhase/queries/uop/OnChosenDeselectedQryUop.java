package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.uop;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.op.SelectedFieldClearQryOp;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnChosenDeselectedQryUop {
    
    public void exec(EditViewPanel panel) {
        try {
            execCore(panel);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore(EditViewPanel panel) {
        panel.getModelTableQueries().getData().clear();
        new SelectedFieldClearQryOp(panel).exec();
    }
    
}
