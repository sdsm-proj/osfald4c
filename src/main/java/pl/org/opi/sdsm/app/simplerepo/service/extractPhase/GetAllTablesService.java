package pl.org.opi.sdsm.app.simplerepo.service.extractPhase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.service.other.GetConn;

@Slf4j
public class GetAllTablesService {

    private static final String[] TYPES = {"TABLE"}; // , "VIEW"};

    public List<String> exec() throws SQLException {
        List<String> tables = new ArrayList<>();
        try ( Connection conn = new GetConn().exec()) {
            ResultSet rs = conn.getMetaData().getTables(null, null, "%", TYPES);
            while (rs.next()) {
                tables.add(rs.getString(3));
                //System.out.println(rs.getString(3));
            }
        }
        return tables;
    }

}
