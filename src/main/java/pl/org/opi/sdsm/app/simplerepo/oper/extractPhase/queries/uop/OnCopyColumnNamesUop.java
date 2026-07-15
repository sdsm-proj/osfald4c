package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop;

import java.util.List;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.ColumnDto;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;

public class OnCopyColumnNamesUop {
    
    public OnCopyColumnNamesUop(ExtractViewPanel panel) {
        this.panel = panel;
    }
    
    private final ExtractViewPanel panel;

    public void exec() {
        String s = "";
        List<ColumnDto> columns = panel.getModelTableQueries().getData();
        for(ColumnDto c: columns) {
            s += c.getColumnName() + "   ";
        }
        panel.getTaColumnNames().setText(s);
    }
    
}
