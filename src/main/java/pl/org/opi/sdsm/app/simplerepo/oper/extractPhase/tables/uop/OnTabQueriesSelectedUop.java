package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop;

import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.op.InitQueriesOp;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;

public class OnTabQueriesSelectedUop {

    public void exec(ExtractViewPanel panel) {
        new InitQueriesOp(panel).exec();
    }

}
