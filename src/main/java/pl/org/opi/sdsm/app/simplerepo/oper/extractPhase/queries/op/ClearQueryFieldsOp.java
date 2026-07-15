package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.op;

import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other.ShowColumnsInTable;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;

public class ClearQueryFieldsOp {

    public ClearQueryFieldsOp(ExtractViewPanel panel) {
        this.panel = panel;
    }
    
    private final ExtractViewPanel panel;

    public void exec() {
        panel.getTextAreaSql().setText("");
        panel.getEditQueryName().setText("");
        new ShowColumnsInTable(panel.getModelTableQueries(), null).exec();        
    }
    
}
