package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.op.InitTablesOp;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnMoveChosen2AvailableUop {

    public void exec(ExtractViewPanel panel, String tableName) {
        try {
            execCore(panel, tableName);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }
    
    private void execCore(ExtractViewPanel panel, String tableName) {
        _SimpleRepoGenUtil.getModel().getTablesModel().getMapTables().remove(tableName);
        
        SdsmCtx.getInstance().getCurrGen().save();
        
        new InitTablesOp(panel).exec();
    }
    
}
