package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.tables.uop;

import pl.org.opi.sdsm.app.simplerepo.oper.editPhase.tables.op.InitTablesOp;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;

public class OnTabTablesSelectedUop {

    public void exec(EditViewPanel panel) {
        new InitTablesOp(panel).exec();
    }
    
}
