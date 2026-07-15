package pl.org.opi.sdsm.app.simplerepo.service.extractPhase.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class TableDetailsComplexDto {
    private final List<ColumnDto> columns = new ArrayList<>(); 
    private final List<PrimaryKeyDto> primaryKeys = new ArrayList<>(); 
}
