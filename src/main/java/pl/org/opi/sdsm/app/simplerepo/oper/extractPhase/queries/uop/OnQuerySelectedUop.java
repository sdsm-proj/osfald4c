package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.queries.QueriesModel;
import pl.org.opi.sdsm.app.simplerepo.model.queries.sub.QueryDetails;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other.ShowColumnsInTable;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.op.ClearQueryFieldsOp;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.op.RefreshQueriesListOp;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnQuerySelectedUop {

    public OnQuerySelectedUop(ExtractViewPanel panel) {
        this.panel = panel;
    }

    private final ExtractViewPanel panel;

    public void exec(String queryName) {
        try {
            execCore();
        } catch (Exception ex) {
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

        QueryDetails queryDetails = queriesModel.getMapQueries().get(selQuery);
        if (queryDetails != null) {
            panel.getTextAreaSql().setText(queryDetails.getSql());
            panel.getEditQueryName().setText(queryDetails.getQueryName());
            new ShowColumnsInTable(panel.getModelTableQueries(), null).exec();
        }
    }

}
