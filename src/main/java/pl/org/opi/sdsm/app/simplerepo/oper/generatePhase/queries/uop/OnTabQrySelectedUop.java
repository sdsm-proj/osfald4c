package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop;

import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.op.InitQryOp;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanel;

public class OnTabQrySelectedUop {
   
    public void exec(GenerateViewPanel panel) {
        new InitQryOp(panel).exec();
    }
    
}
