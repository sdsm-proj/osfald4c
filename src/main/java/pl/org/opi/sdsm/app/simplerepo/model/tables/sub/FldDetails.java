package pl.org.opi.sdsm.app.simplerepo.model.tables.sub;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.org.opi.util.fldNames.FldNamesUtils;

@Data
public class FldDetails {

    private String fldName;
    private int dbTypeInt;
    private String dbTypeStr;
    private boolean notNull;
    private boolean autoIncrement;
    private boolean primaryKey;
    private String javaTypeDefault;
    private String javaTypeFinal;
    private String javaNameDefault;
    private String javaNameFinal;

    @JsonIgnore
    public String getGetterName() {
        String s = "";
        if ("boolean".equals(javaTypeFinal)) {
            s += "is";
        } else {
            s += "get";
        }
        s += FldNamesUtils.firstLetterUpper(javaNameFinal);
        return s;
    }

    @JsonIgnore
    public String getSetterName() {
        String s = "";
        s += "set";
        s += FldNamesUtils.firstLetterUpper(javaNameFinal);
        return s;
    }

}
