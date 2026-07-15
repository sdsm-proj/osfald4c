package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other.ShowColumnsInTable;
import pl.org.opi.sdsm.app.simplerepo.oper.other.columnDupl.FindColumnDuplicatesOp;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.GetQueryDetailsService;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.QueryDetailsComplexDto;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnRunSqlUop {

    public OnRunSqlUop(ExtractViewPanel panel) {
        this.panel = panel;
    }
    
    private final ExtractViewPanel panel;
    
    private String sql;
    
    private QueryDetailsComplexDto dc;
    
    public void exec() {
        try {
            execCore();
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }
    
    private void execCore() throws SQLException {
        checkSql();
        runSql();
        showColumnsInTable();
        checkColumnDuplicates();
    }
    
    private void checkSql() {
        sql = panel.getTextAreaSql().getText().trim();
        if (StringUtils.isBlank(sql)) {
            throw new OsfaldRuntimeException("SQL cannot be empty");
        }
    }
    
    private void runSql() throws SQLException {
        dc = new GetQueryDetailsService().exec(sql);
    }
    
    private void showColumnsInTable() {
        new ShowColumnsInTable(panel.getModelTableQueries(), dc.getColumns()).exec();
    }
    
    private void checkColumnDuplicates() {
        FindColumnDuplicatesOp findDuplicates = new FindColumnDuplicatesOp(dc.getColumns());
        findDuplicates.exec();
        if (!findDuplicates.getDuplicates().isEmpty()) {
            String msg = "";
            msg += "There are column name duplicates:" + "\n";
            msg += findDuplicates.getDuplicateColumnsAsStr();
            OsfaldMsgBox.warn(msg);
        }
    }
    
}
