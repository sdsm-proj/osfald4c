package pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto;

import lombok.Data;

@Data
public class ColumnDto {
    private String tableCat;
    private String tableSchem;
    private String tableName;
    private String columnName;
    private int dataType;
    private String typeName;
    private String columnSize;
    private boolean notNull;
    private boolean autoIncrement;
}
