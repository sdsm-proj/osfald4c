package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.tables.op;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;

@Slf4j
public class SelectedFieldClearOp {
    
    public SelectedFieldClearOp(EditViewPanel panel) {
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
        panel.getEdJavaNameDefault().setText("");
        panel.getEdJavaNameFinal().setText("");
        panel.getEdJavaTypeDefault().setText("");
        panel.getEdJavaTypeFinal().setText("");
    }
    
}
