package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop;

import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;

public class OnClearTableQueryUop {
    
    public OnClearTableQueryUop(ExtractViewPanel panel) {
        this.panel = panel;
    }
    
    private final ExtractViewPanel panel;
    
    public void exec() {
        panel.getModelTableQueries().setData(null);
        panel.getModelTableQueries().fireTableStructureChanged();
    }
    
}
