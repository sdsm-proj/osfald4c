package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop;

import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;

public class OnClearColumnNamesUop {
    
    public OnClearColumnNamesUop(ExtractViewPanel panel) {
        this.panel = panel;
    }
    
    private final ExtractViewPanel panel;

    public void exec() {
        panel.getTaColumnNames().setText("");
    }
    
}
