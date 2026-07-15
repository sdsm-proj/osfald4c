package pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.other;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.TableDetails;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.ColumnDto;
import pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto.TableDetailsComplexDto;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

@Slf4j
public class TableDetailsConverter {

    public TableDetailsConverter(TableDetailsComplexDto dc) {
        this.dc = dc;
    }

    private final TableDetailsComplexDto dc;

    private final TableDetails rslt = new TableDetails();

    public TableDetails exec() throws Exception {
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
        tableNameSchema();
        copyFields();
        setPrimaryKey();
    }

    private void tableNameSchema() {
        if (dc.getColumns().isEmpty()) {
            throw new OsfaldRuntimeException("TableDetailsConverter. Table has no column.");
        } else {
            rslt.setTableName(dc.getColumns().get(0).getTableName());
            rslt.setTableSchem(dc.getColumns().get(0).getTableSchem());
        }
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

    private void setPrimaryKey() {
        if (dc.getPrimaryKeys().size() != 1) {
            throw new OsfaldRuntimeException("Table [" + rslt.getTableName() + "] should have primary key that consists of one field.");
        }
        String pkCol = dc.getPrimaryKeys().get(0).getColumnName();
        FldDetails pkFld = rslt.getMapFlds().get(pkCol);
        if (pkFld == null) {
            throw new OsfaldRuntimeException("No field for PK column [" + pkCol + "] in table [" + rslt.getTableName() + "].");
        }
        pkFld.setPrimaryKey(true);
    }

}
