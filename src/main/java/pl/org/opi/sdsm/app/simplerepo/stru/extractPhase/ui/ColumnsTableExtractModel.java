package pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.ColumnDto;

@Data
@EqualsAndHashCode(callSuper = false)
public class ColumnsTableExtractModel extends AbstractTableModel {

    private final String[] columnNames = {"tableName", "columnName", "dataType", "typeName", "columnSize", "notNull", "autoIncrement"};

    private List<ColumnDto> data;

    @Override
    public int getRowCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        if (data != null) {
            ColumnDto r = data.get(row);
            switch (col) {
                case 0:
                    return r.getTableName();
                case 1:
                    return r.getColumnName();
                case 2:
                    return r.getDataType();
                case 3:
                    return r.getTypeName();
                case 4:
                    return r.getColumnSize();
                case 5:
                    return (r.isNotNull()) ? "X" : "";
                case 6:
                    return (r.isAutoIncrement()) ? "X" : "";
            }
        }
        return "?";
    }

}
