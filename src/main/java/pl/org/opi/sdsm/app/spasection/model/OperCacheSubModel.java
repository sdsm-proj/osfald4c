package pl.org.opi.sdsm.app.spasection.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.org.opi.util.genartifactdepot.GenArtifactDepot;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.util.classdepot.ClassDepot;

@Data
public class OperCacheSubModel {
    @JsonIgnore
    private ClassDepot classDepot;
    @JsonIgnore
    private String sectionFldName;
    @JsonIgnore
    private MetaNode selectedSectionPart;
    @JsonIgnore
    private GenArtifactDepot artifactDepot = new GenArtifactDepot();
}
