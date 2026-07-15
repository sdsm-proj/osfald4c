package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.model.Scenario02Config;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.util.classdepot.ClassCuComplex;
import pl.org.opi.util.classdepot.ClassDepot;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Scenario02Model {

    private Scenario02Config config = new Scenario02Config();

    @JsonIgnore
    private ClassDepot classDepot;

    @JsonIgnore
    private ClassCuComplex dokumentCux;

    @JsonIgnore
    private MetaNode entireSectionNode;

    @JsonIgnore
    private MetaNode selectedPartNode;

    @JsonIgnore
    private Map<String, String> vars = new LinkedHashMap<>();



}
