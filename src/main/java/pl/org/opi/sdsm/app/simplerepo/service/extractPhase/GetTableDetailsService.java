package pl.org.opi.sdsm.app.simplerepo.service.extractPhase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.ColumnDto;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.PrimaryKeyDto;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.TableDetailsComplexDto;
import pl.org.opi.sdsm.app.simplerepo.service.other.GetConn;

@Slf4j
public class GetTableDetailsService {

    public TableDetailsComplexDto exec(String tableName) throws SQLException {
        TableDetailsComplexDto dc = new TableDetailsComplexDto();
        //
        try ( Connection conn = new GetConn().exec()) {
            //
            {
                ResultSet rs = conn.getMetaData().getColumns(null, null, tableName, null);
                while (rs.next()) {
                    ColumnDto col = new ColumnDto();
                    col.setTableCat(rs.getString("TABLE_CAT"));
                    col.setTableSchem(rs.getString("TABLE_SCHEM"));
                    col.setTableName(rs.getString("TABLE_NAME"));
                    col.setColumnName(rs.getString("COLUMN_NAME"));
                    col.setDataType(Integer.parseInt(rs.getString("DATA_TYPE")));
                    col.setTypeName(rs.getString("TYPE_NAME"));
                    col.setColumnSize(rs.getString("COLUMN_SIZE"));
                    col.setNotNull(!("yes".equalsIgnoreCase(rs.getString("IS_NULLABLE"))));
                    col.setAutoIncrement(("yes".equalsIgnoreCase(rs.getString("IS_AUTOINCREMENT"))));
                    dc.getColumns().add(col);
                }
            }
            //
            {
                ResultSet rs = conn.getMetaData().getPrimaryKeys(null, null, tableName);
                while (rs.next()) {
                    PrimaryKeyDto pk = new PrimaryKeyDto();
                    pk.setColumnName(rs.getString("COLUMN_NAME"));
                    pk.setPkName(rs.getString("PK_NAME"));
                    pk.setKeySeq(rs.getString("KEY_SEQ"));
                    dc.getPrimaryKeys().add(pk);
                }
            }
            //
        } // try
        return dc;
    }

}
