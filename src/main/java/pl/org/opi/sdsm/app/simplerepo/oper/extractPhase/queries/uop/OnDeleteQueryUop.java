package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.queries.QueriesModel;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.op.ClearQueryFieldsOp;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.op.RefreshQueriesListOp;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnDeleteQueryUop {

    public OnDeleteQueryUop(ExtractViewPanel panel) {
        this.panel = panel;
    }
    
    private final ExtractViewPanel panel;
    
    public void exec() {
        try {
            execCore();
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }
    
    private void execCore() {
        QueriesModel queriesModel = _SimpleRepoGenUtil.getModel().getQueriesModel();

        String selQuery = panel.getListQueries().getSelectedValue();
        if (StringUtils.isBlank(selQuery)) {
            return;
        }
        if (OsfaldMsgBox.yesNo("Do you want to delete query: " + selQuery + "?") != true) {
            return;
        }

        queriesModel.getMapQueries().remove(selQuery);
        SdsmCtx.getInstance().getCurrGen().save();
        new RefreshQueriesListOp(panel, null).exec();
        new ClearQueryFieldsOp(panel).exec();
    }
    
}
