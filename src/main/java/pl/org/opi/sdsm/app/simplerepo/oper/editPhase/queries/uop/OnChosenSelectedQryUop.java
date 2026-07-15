package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.uop;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.queries.sub.QueryDetails;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.oper.editPhase.other.SetDefaultJavaNamesOp;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class OnChosenSelectedQryUop {
    
    public void exec(EditViewPanel panel, String qryName) {
        try {
            execCore(panel, qryName);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore(EditViewPanel panel, String qryName) {
        QueryDetails queryDetails = _SimpleRepoGenUtil.getModel().getQueriesModel().getMapQueries().get(qryName);

        panel.getTaQrySql().setText(queryDetails.getSql());

        new SetDefaultJavaNamesOp(queryDetails.getMapFlds(), false).exec();
        List<FldDetails> listOfFields = queryDetails.getMapFlds().values().stream().collect(Collectors.toList());
        panel.getModelTableQueries().setData(listOfFields);
        panel.getModelTableQueries().fireTableStructureChanged();
        SdsmCtx.getInstance().getCurrGen().save();
    }
    
}
