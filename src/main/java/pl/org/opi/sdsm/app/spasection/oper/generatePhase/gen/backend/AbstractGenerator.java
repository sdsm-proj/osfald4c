package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.model.SpaSectionGenModel;
import pl.org.opi.sdsm.app.spasection.model.OperCacheSubModel;
import pl.org.opi.util.classdepot.ClassDepot;
import pl.org.opi.util.genartifactdepot.GenArtifactDepot;

public abstract class AbstractGenerator {

    protected SpaSectionGenModel getMdxModel() {
        return _SpaSectionGenUtil.getModel();
    }

    protected ClassDepot getMdxClassDepot() {
        return _SpaSectionGenUtil.getModel().getOperCache().getClassDepot();
    }

    protected GenArtifactDepot getMdxArtifactDepot() {
        return _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot();
    }

    protected OperCacheSubModel getMdxOperCache() {
        return _SpaSectionGenUtil.getModel().getOperCache();
    }

}
