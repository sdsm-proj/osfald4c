package pl.org.opi.sdsm.app.spasection.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.org.opi.sdsm.app.spasection.model.sub.EditDocumentLevel;
import pl.org.opi.sdsm.app.spasection.model.sub.ConfigPrjLevel;
import pl.org.opi.sdsm.app.spasection.model.sub.EditSectionLevel;
import pl.org.opi.sdsm.app.spasection.model.sub.GenVars;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;

@Data
@EqualsAndHashCode(callSuper=false)
public class SpaSectionGenModel extends BaseGenModel {

    @JsonIgnore
    private OperCacheSubModel operCache = new OperCacheSubModel();

    private ConfigPrjLevel configPrjLevel = new ConfigPrjLevel();
    private EditDocumentLevel editDocumentLevel = new EditDocumentLevel();
    private EditSectionLevel editSectionLevel = new EditSectionLevel();
    private GenVars genVars = new GenVars();
}
