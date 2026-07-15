package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.tables.op;

import java.sql.SQLException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;

@Slf4j
public class InitTablesOp {

    public InitTablesOp(EditViewPanel panel) {
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
        showChosenTables();
    }

    private void clearSelection() {
        panel.getListChosenTables().clearSelection();
    }

    private void showChosenTables() {
        panel.getModelListChosenTables().clear();
        panel.getModelListChosenTables().addAll(_SimpleRepoGenUtil.getModel().getTablesModel().getMapTables().keySet().stream().collect(Collectors.toList()));
    }

}
