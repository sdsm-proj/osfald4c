package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.tables.op;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;

@Slf4j
public class SelectedFieldShowOp {
    
    public SelectedFieldShowOp(EditViewPanel panel) {
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

    private void execCore() throws SQLException {
        int rowIdx = panel.getTableTable().getSelectedRow();
        FldDetails row = panel.getModelTableTables().getData().get(rowIdx);
        panel.getEdJavaNameDefault().setText(row.getJavaNameDefault());
        panel.getEdJavaNameFinal().setText(row.getJavaNameFinal());
        panel.getEdJavaTypeDefault().setText(row.getJavaTypeDefault());
        panel.getEdJavaTypeFinal().setText(row.getJavaTypeFinal());
    }
    
}
