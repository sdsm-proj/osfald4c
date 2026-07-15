package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.uop;

import pl.org.opi.sdsm.app.simplerepo.oper.editPhase.queries.op.InitQryOp;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;

public class OnTabQrySelectedUop {
    
    public void exec(EditViewPanel panel) {
        new InitQryOp(panel).exec();
    }
    
}
