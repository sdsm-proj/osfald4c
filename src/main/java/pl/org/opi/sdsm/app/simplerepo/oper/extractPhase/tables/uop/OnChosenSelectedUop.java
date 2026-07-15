package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other.ShowColumnsInTable;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.GetTableDetailsService;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.TableDetailsComplexDto;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnChosenSelectedUop {
    
    public void exec(ExtractViewPanel panel, String tableName) {
        try {
            execCore(panel, tableName);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }
    
    private void execCore(ExtractViewPanel panel, String tableName) throws SQLException {
        TableDetailsComplexDto dc = new GetTableDetailsService().exec(tableName);
        new ShowColumnsInTable(panel.getModelTableTables(), dc.getColumns()).exec();
    }
    
}
