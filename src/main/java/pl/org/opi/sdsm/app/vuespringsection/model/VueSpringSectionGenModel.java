package pl.org.opi.sdsm.app.vuespringsection.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.org.opi.sdsm.app.vuespringsection.model.parsedproject.ParsedProject;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.Scenario01Model;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.Scenario02Model;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;

@Data
@EqualsAndHashCode(callSuper=false)
public class VueSpringSectionGenModel extends BaseGenModel {
    private String emptyName;

    @JsonIgnore
    private final ParsedProject parsedProject = new ParsedProject();

    @JsonIgnore
    private final Scenario01Model scenario01Model = new Scenario01Model();

    @JsonIgnore
    private final Scenario02Model scenario02Model = new Scenario02Model();

}
