package pl.org.opi.sdsm.app.simplerepo.model.tables.sub;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.LinkedHashMap;
import lombok.Data;

@Data
public class TableDetails {
    private String tableName;
    private String tableSchem;
    private final GenerateParams generateParams = new GenerateParams();
    private final GenerateDetails generateDetails = new GenerateDetails();
    private final LinkedHashMap<String, FldDetails> mapFlds = new LinkedHashMap<>();
    
    @JsonIgnore
    public FldDetails getPrimaryKey() {
        for (FldDetails fld : getMapFlds().values()) {
            if (fld.isPrimaryKey()) {
                return fld;
            }
        }
        return null;
    }

    @JsonIgnore
    public FldDetails getAutoIncrement() {
        for (FldDetails fld : getMapFlds().values()) {
            if (fld.isAutoIncrement()) {
                return fld;
            }
        }
        return null;
    }
    
}
