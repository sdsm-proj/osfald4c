package pl.org.opi.sdsm.app.frontenddto.model.var;

import lombok.Data;

@Data
public class GeneratePhaseVariablesModel {
    private String pureTypeName;
    private String dtoTypeName;
    private String dtoProps;
    private String dtoPropsSchema;
    private String dtoPropsSchemaSrc;
}
