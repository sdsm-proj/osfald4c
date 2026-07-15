package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.uop;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.queries.sub.QueryDetails;
import pl.org.opi.sdsm.app.simplerepo.oper.editPhase.other.SetDefaultJavaNamesOp;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnResetTableToDefaultsQryUop {
    
    public void exec(EditViewPanel panel, String queryName) {
        try {
            execCore(panel, queryName);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore(EditViewPanel panel, String queryName) {
        if (!OsfaldMsgBox.yesNo("Reset names and types to default values?")) return;
        
        QueryDetails queryDetails = _SimpleRepoGenUtil.getModel().getQueriesModel().getMapQueries().get(queryName);
        new SetDefaultJavaNamesOp(queryDetails.getMapFlds(), true).exec();
        panel.getModelTableQueries().fireTableStructureChanged();
        SdsmCtx.getInstance().getCurrGen().save();
    }
    
    
}
