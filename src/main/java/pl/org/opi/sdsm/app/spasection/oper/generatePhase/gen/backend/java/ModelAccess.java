package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.model.sub.EditDocumentLevel;
import pl.org.opi.sdsm.app.spasection.model.sub.ConfigPrjLevel;
import pl.org.opi.sdsm.app.spasection.model.sub.EditSectionLevel;
import pl.org.opi.sdsm.app.spasection.model.sub.GenVars;
import pl.org.opi.util.genartifactdepot.GenArtifactDepot;

public class ModelAccess {

    public ConfigPrjLevel getConfigPrjLevel() {
        return _SpaSectionGenUtil.getModel().getConfigPrjLevel();
    }

    public EditDocumentLevel getConfigDocLevel() {
        return _SpaSectionGenUtil.getModel().getEditDocumentLevel();
    }

    public EditSectionLevel getEditSectionLevel() {
        return _SpaSectionGenUtil.getModel().getEditSectionLevel();
    }

    public GenVars getGenVars() {
        return _SpaSectionGenUtil.getModel().getGenVars();
    }

    public GenArtifactDepot getArtifactDepot() {
        return _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot();
    }




}
