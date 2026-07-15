package pl.org.opi.sdsm.app.simplerepo.service.extractPhase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.ColumnDto;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.QueryDetailsComplexDto;
import pl.org.opi.sdsm.app.simplerepo.service.other.GetConn;

public class GetQueryDetailsService {

    public QueryDetailsComplexDto exec(String sql) throws SQLException {
        QueryDetailsComplexDto dc = new QueryDetailsComplexDto();
        try ( Connection conn = new GetConn().exec()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int cc = md.getColumnCount();
            for (int i = 1; i <= cc; i++) {
                ColumnDto col = new ColumnDto();
                col.setTableCat(md.getCatalogName(i));
                col.setTableSchem(md.getSchemaName(i));
                col.setTableName(md.getTableName(i));
                col.setColumnName(md.getColumnName(i));
                col.setDataType(md.getColumnType(i));
                col.setTypeName(md.getColumnTypeName(i));
                col.setColumnSize("" + md.getColumnDisplaySize(i));
                col.setNotNull(!(md.isNullable(i) > 0));
                col.setAutoIncrement(md.isAutoIncrement(i));
                dc.getColumns().add(col);
            }
        }
        return dc;
    }

}
