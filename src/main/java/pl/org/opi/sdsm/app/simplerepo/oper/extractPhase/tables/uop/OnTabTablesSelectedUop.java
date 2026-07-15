package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop;

import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.op.InitTablesOp;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;

public class OnTabTablesSelectedUop {

    public void exec(ExtractViewPanel panel) {
        new InitTablesOp(panel).exec();
    }

}
