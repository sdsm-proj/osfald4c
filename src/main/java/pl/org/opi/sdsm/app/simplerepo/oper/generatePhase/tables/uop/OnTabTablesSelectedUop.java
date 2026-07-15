package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.uop;

import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.op.InitTablesOp;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanel;

public class OnTabTablesSelectedUop {
  
    public void exec(GenerateViewPanel panel) {
        new InitTablesOp(panel).exec();
    }
    
}
