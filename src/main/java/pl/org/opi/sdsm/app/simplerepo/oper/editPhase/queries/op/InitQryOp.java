package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.op;

import java.sql.SQLException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;

@Slf4j
public class InitQryOp {
    
    public InitQryOp(EditViewPanel panel) {
        this.panel = panel;
    }

    private final EditViewPanel panel;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() throws SQLException {
        clearSelection();
        showChosenQ();
    }

    private void clearSelection() {
        panel.getListChosenQ().clearSelection();
    }

    private void showChosenQ() {
        panel.getModelListChosenQ().clear();
        panel.getModelListChosenQ().addAll(_SimpleRepoGenUtil.getModel().getQueriesModel().getMapQueries().keySet().stream().collect(Collectors.toList()));
    }
    
}
