package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.uop;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.commons.fldNames.FldNamesUtils;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnSaveNameQryUop {
    
    public OnSaveNameQryUop(EditViewPanel panel) {
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
        String newName = panel.getEdJavaNameFinalQ().getText();
        if (StringUtils.isBlank(newName)) {
            OsfaldMsgBox.error("Field name cannot be empty");
            return;
        }
        newName = newName.trim();
        newName = FldNamesUtils.firstLetterLower(newName);
        
        row.setJavaNameFinal(newName);
        panel.getModelTableQueries().fireTableDataChanged();
        panel.getTableQuery().getSelectionModel().setSelectionInterval(rowIdx, rowIdx);
        
        SdsmCtx.getInstance().getCurrGen().save();
    }
    
}
