package pl.org.opi.sdsm.app.simplerepo.oper.other.columnDupl;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import pl.org.opi.util.str.Strings2Lines;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.ColumnDto;

public class FindColumnDuplicatesOp {

    public FindColumnDuplicatesOp(List<ColumnDto> columns) {
        this.columns = columns;
    }

    private final List<ColumnDto> columns;

    @Getter
    private final List<String> duplicates = new ArrayList<>();

    public void exec() {
        duplicates.clear();
        for (ColumnDto c : columns) {
            if (columnCount(c.getColumnName()) > 1) {
                if (!duplicates.contains(c.getColumnName())) {
                    duplicates.add(c.getColumnName());
                }
            }
        }
    }

    public String getDuplicateColumnsAsStr() {
        List<String> lines = new Strings2Lines(duplicates, ",", Integer.MAX_VALUE).exec();
        if (!lines.isEmpty()) {
            return lines.get(0);
        }
        return "";
    }

    private int columnCount(String columnName) {
        int cnt = 0;
        for (ColumnDto c : columns) {
            if (columnName.equals(c.getColumnName())) {
                cnt++;
            }
        }
        return cnt;
    }

}
