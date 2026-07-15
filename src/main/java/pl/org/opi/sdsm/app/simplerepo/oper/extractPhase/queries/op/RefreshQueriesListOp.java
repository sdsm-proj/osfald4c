package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.op;

import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.queries.QueriesModel;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class RefreshQueriesListOp {

    public RefreshQueriesListOp(ExtractViewPanel panel, String valueToBeVisible) {
        this.panel = panel;
        this.valueToBeVisible = valueToBeVisible;
    }

    private final ExtractViewPanel panel;

    private final String valueToBeVisible;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() {
        QueriesModel queriesModel = _SimpleRepoGenUtil.getModel().getQueriesModel();
        panel.getModelListQueries().clear();
        panel.getModelListQueries().addAll(queriesModel.getMapQueries().keySet().stream().sorted().collect(Collectors.toList()));

        if (StringUtils.isNotBlank(valueToBeVisible)) {
            int idx = panel.getModelListQueries().indexOf(valueToBeVisible);
            if (idx >= 0) {
                panel.getListQueries().ensureIndexIsVisible(idx);
            }
        }

    }

}
