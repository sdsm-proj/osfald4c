package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.op;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;

@Slf4j
public class InitQueriesOp {

    public InitQueriesOp(ExtractViewPanel panel) {
        this.panel = panel;
    }
    
    private final ExtractViewPanel panel;
    
    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() {
        System.out.println("InitQueriesOp");
        new RefreshQueriesListOp(panel, null).exec();
    }
    
}
