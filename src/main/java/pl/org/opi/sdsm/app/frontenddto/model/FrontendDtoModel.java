package pl.org.opi.sdsm.app.frontenddto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.org.opi.sdsm.app.frontenddto.model.var.FrontendDtoVariablesModel;
import pl.org.opi.sdsm.app.frontenddto.model.var.GeneratePhaseVariablesModel;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;

@Data
@EqualsAndHashCode(callSuper=false)
public class FrontendDtoModel extends BaseGenModel {
    @JsonIgnore
    private FrontendDtoVariablesModel vars = new FrontendDtoVariablesModel();
    @JsonIgnore
    private GeneratePhaseVariablesModel genVars;
}
