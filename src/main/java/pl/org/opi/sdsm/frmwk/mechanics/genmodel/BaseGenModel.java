package pl.org.opi.sdsm.frmwk.mechanics.genmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BaseGenModel implements GenModel {

    private String code;
    
    private String prjShortName;
    
    // Not serialize - pole tylko w pamięci
    @JsonIgnore
    private String prjFullFileName;
    
    // Not serialize - pole tylko w pamięci
    @JsonIgnore
    private String prjRootPath;
    
}
