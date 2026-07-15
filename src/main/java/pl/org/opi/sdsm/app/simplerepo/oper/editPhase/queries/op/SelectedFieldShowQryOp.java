package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.op;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;

@Slf4j
public class SelectedFieldShowQryOp {
    
    public SelectedFieldShowQryOp(EditViewPanel panel) {
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
        int rowIdx = panel.getTableQuery().getSelectedRow();
        FldDetails row = panel.getModelTableQueries().getData().get(rowIdx);
        panel.getEdJavaNameDefaultQ().setText(row.getJavaNameDefault());
        panel.getEdJavaNameFinalQ().setText(row.getJavaNameFinal());
        panel.getEdJavaTypeDefaultQ().setText(row.getJavaTypeDefault());
        panel.getEdJavaTypeFinalQ().setText(row.getJavaTypeFinal());
    }
    
}
