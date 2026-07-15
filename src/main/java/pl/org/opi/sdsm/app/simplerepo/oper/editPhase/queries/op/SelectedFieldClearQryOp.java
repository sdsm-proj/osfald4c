package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.op;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;

@Slf4j
public class SelectedFieldClearQryOp {

        public SelectedFieldClearQryOp(EditViewPanel panel) {
        this.panel = panel;
    }

    private final EditViewPanel panel;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() {
        panel.getEdJavaNameDefaultQ().setText("");
        panel.getEdJavaNameFinalQ().setText("");
        panel.getEdJavaTypeDefaultQ().setText("");
        panel.getEdJavaTypeFinalQ().setText("");
    }

}
