package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.uop;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnSaveTypeQryUop {
   
    public OnSaveTypeQryUop(EditViewPanel panel) {
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
        if (rowIdx < 0) {
            OsfaldMsgBox.error("Select field first");
            return;
        }
        FldDetails row = panel.getModelTableQueries().getData().get(rowIdx);
        String newType = panel.getEdJavaTypeFinalQ().getText();
        if (StringUtils.isBlank(newType)) {
            OsfaldMsgBox.error("Field type cannot be empty");
            return;
        }
        newType = newType.trim();
        
        row.setJavaTypeFinal(newType);
        panel.getModelTableQueries().fireTableDataChanged();
        panel.getTableQuery().getSelectionModel().setSelectionInterval(rowIdx, rowIdx);
        
        SdsmCtx.getInstance().getCurrGen().save();
    }
    
}
