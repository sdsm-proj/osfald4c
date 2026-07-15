package pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;

@Data
@EqualsAndHashCode(callSuper = false)
public class ColumnsTableEditModel extends AbstractTableModel {

    private final String[] columnNames = {"fldName", "dbTypeStr", "notNull", "autoIncrement", "javaNameDefault", "javaNameFinal", "javaTypeDefault", "javaTypeFinal"};
    
    private List<FldDetails> data;

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
            FldDetails r = data.get(row);
            switch (col) {
                case 0:
                    return r.getFldName();
                case 1:
                    return r.getDbTypeStr();
                case 2:
                    return (r.isNotNull()) ? "X" : "";
                case 3:
                    return (r.isAutoIncrement()) ? "X" : "";
                case 4:
                    return r.getJavaNameDefault();
                case 5:
                    return r.getJavaNameFinal();
                case 6:
                    return r.getJavaTypeDefault();
                case 7:
                    return r.getJavaTypeFinal();
            }
        }
        return "?";
    }
    
}
