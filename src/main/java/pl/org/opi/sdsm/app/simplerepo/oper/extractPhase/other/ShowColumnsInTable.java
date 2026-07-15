package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other;

import java.util.List;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.ColumnDto;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ColumnsTableExtractModel;

public class ShowColumnsInTable {

    public ShowColumnsInTable(ColumnsTableExtractModel tableModel, List<ColumnDto> columns) {
        this.tableModel = tableModel;
        this.columns = columns;
    }
    
    private final ColumnsTableExtractModel tableModel;
    
    private final List<ColumnDto> columns;
    
    public void exec() {
        tableModel.setData(columns);
        tableModel.fireTableStructureChanged();
    }
    
}
