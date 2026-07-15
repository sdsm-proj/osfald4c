package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.tables.uop;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.TableDetails;
import pl.org.opi.sdsm.app.simplerepo.oper.editPhase.other.SetDefaultJavaNamesOp;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnChosenSelectedUop {
    
    public void exec(EditViewPanel panel, String tableName) {
        try {
            execCore(panel, tableName);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore(EditViewPanel panel, String tableName) {
        TableDetails tableDetails = _SimpleRepoGenUtil.getModel().getTablesModel().getMapTables().get(tableName);
        new SetDefaultJavaNamesOp(tableDetails.getMapFlds(), false).exec();
        List<FldDetails> listOfFields = tableDetails.getMapFlds().values().stream().collect(Collectors.toList());
        panel.getModelTableTables().setData(listOfFields);
        panel.getModelTableTables().fireTableStructureChanged();
        SdsmCtx.getInstance().getCurrGen().save();
    }
    
}
