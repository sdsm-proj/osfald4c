package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop;

import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.queries.QueriesModel;
import pl.org.opi.sdsm.app.simplerepo.model.queries.sub.QueryDetails;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other.QueryDetailsConverter;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other.ShowColumnsInTable;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.op.RefreshQueriesListOp;
import pl.org.opi.sdsm.app.simplerepo.oper.other.columnDupl.FindColumnDuplicatesOp;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.GetQueryDetailsService;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.QueryDetailsComplexDto;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnSaveQueryUop {

    public OnSaveQueryUop(ExtractViewPanel panel) {
        this.panel = panel;
        this.queryName = panel.getEditQueryName().getText().trim();
        this.sql = panel.getTextAreaSql().getText().trim();
    }
    
    private final ExtractViewPanel panel;

    private final String queryName;
    
    private final String sql;
    
    public void exec() {
        try {
            execCore();
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }
    
    private void execCore() throws SQLException, Exception {
        QueriesModel queriesModel = _SimpleRepoGenUtil.getModel().getQueriesModel();

        // Query name empty?
        if (StringUtils.isBlank(queryName)) {
            throw new OsfaldRuntimeException("Query name cannot be empty");
        }
        
        // Overwrite?
        if (queriesModel.getMapQueries().get(queryName) != null) {
            if (OsfaldMsgBox.yesNo("Query:" + queryName + " already exists. Do you want to overwrite it?") != true) {
                return;
            }
        }
        
        // Read query structure
        QueryDetailsComplexDto dc = new GetQueryDetailsService().exec(sql);
        
        // Show structure
        new ShowColumnsInTable(panel.getModelTableQueries(), dc.getColumns()).exec();
        
        // Check duplicates
        checkColumnDuplicates(dc);
        
        // Add QueryDetails to map
        QueryDetails queryDetails = new QueryDetailsConverter(dc, queryName, sql).exec();
        queriesModel.getMapQueries().put(queryName, queryDetails);

        SdsmCtx.getInstance().getCurrGen().save();
        
        new RefreshQueriesListOp(panel, queryName).exec();
    }
    
    private void checkColumnDuplicates(QueryDetailsComplexDto dc) {
        FindColumnDuplicatesOp findDuplicates = new FindColumnDuplicatesOp(dc.getColumns());
        findDuplicates.exec();
        if (!findDuplicates.getDuplicates().isEmpty()) {
            String msg = "";
            msg += "There are column name duplicates:" + "\n";
            msg += findDuplicates.getDuplicateColumnsAsStr();
            throw new OsfaldRuntimeException(msg);
        }
    }
    
    
}
