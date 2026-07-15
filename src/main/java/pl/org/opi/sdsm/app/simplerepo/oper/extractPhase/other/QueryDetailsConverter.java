package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.model.queries.sub.QueryDetails;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.ColumnDto;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.QueryDetailsComplexDto;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

@Slf4j
public class QueryDetailsConverter {

    public QueryDetailsConverter(QueryDetailsComplexDto dc, String queryName, String sql) {
        this.dc = dc;
        this.queryName = queryName;
        this.sql = sql;
    }
    
    private final QueryDetailsComplexDto dc;
    private final String queryName;
    private final String sql;
    
    private final QueryDetails rslt = new QueryDetails();
    
    public QueryDetails exec() throws Exception {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            //MsgBox.error(ex);
            throw ex;
        }
        return rslt;
    }

    private void execCore() throws Exception {
        if (dc.getColumns().isEmpty()) {
            throw new OsfaldRuntimeException("QueryDetailsConverter. Query result has no column.");
        }
        rslt.setQueryName(queryName);
        rslt.setSql(sql);
        copyFields();
    }
    
    private void copyFields() {
        for (ColumnDto c : dc.getColumns()) {
            FldDetails f = new FldDetails();
            f.setFldName(c.getColumnName());
            f.setDbTypeInt((c.getDataType()));
            f.setDbTypeStr(c.getTypeName());
            f.setNotNull(c.isNotNull());
            f.setAutoIncrement(c.isAutoIncrement());
            rslt.getMapFlds().put(f.getFldName(), f);
        }
    }
    
}
