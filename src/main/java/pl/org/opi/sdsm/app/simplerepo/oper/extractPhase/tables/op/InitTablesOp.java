package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.op;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.GetAllTablesService;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

@Slf4j
public class InitTablesOp {

    public InitTablesOp(ExtractViewPanel panel) {
        this.panel = panel;
    }

    private final ExtractViewPanel panel;

    private final List<String> allTables = new ArrayList<>();
    private final List<String> availableTables = new ArrayList<>();
    private final List<String> chosenTables = new ArrayList<>();
    
    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() throws SQLException {
        clearSelection();
        loadAllTables();
        showChosenTables();
        showAvailableTables();

        SdsmCtx.getInstance().getCurrGen().save();
    }

    private void clearSelection() {
        panel.getListAvailableTables().clearSelection();
        panel.getListChosenTables().clearSelection();
    }

    private void loadAllTables() throws SQLException {
        allTables.clear();
        allTables.addAll(new GetAllTablesService().exec());
    }

    private void showChosenTables() {
        chosenTables.clear();
        chosenTables.addAll(_SimpleRepoGenUtil.getModel().getTablesModel().getMapTables().keySet().stream().collect(Collectors.toList()));
        panel.getModelListChosenTables().clear();
        panel.getModelListChosenTables().addAll(chosenTables);
    }

    private void showAvailableTables() {
        availableTables.clear();
        for (String t : allTables) {
            if (!chosenTables.contains(t)) {
                availableTables.add(t);
            }
        }
        panel.getModelListAvailableTables().clear();
        panel.getModelListAvailableTables().addAll(availableTables);
    }

}
