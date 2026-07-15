package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop;

import java.sql.SQLException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.tables.TablesModel;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.TableDetails;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other.TableDetailsConverter;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.op.InitTablesOp;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.GetTableDetailsService;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.TableDetailsComplexDto;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnMoveAvailable2ChosenUop {

    public void exec(ExtractViewPanel panel, String tableName) {
        try {
            execCore(panel, tableName);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore(ExtractViewPanel panel, String tableName) throws Exception {
        // Process stopped if exception (e.g. no one field primary key)
        extractAndSave(tableName);

        // Move table to chosen
//        List<String> selectedTables = _SimpleRepoGenUtil.getModel().getTablesModel().getChosenTables();
//        if (!selectedTables.contains(tableName)) {
//            selectedTables.add(tableName);
//        }

        // Refresh panel
        new InitTablesOp(panel).exec();
    }

    private void extractAndSave(String tableName) throws SQLException, Exception {
        TablesModel tablesModel = _SimpleRepoGenUtil.getModel().getTablesModel();

        TableDetailsComplexDto detailsComplex = new GetTableDetailsService().exec(tableName);
        TableDetails td = new TableDetailsConverter(detailsComplex).exec();
        tablesModel.getMapTables().put(tableName, td);

        SdsmCtx.getInstance().getCurrGen().save();
    }

}
