package pl.org.opi.sdsm.app.simplerepo;

import pl.org.opi.sdsm.app.simplerepo.model.SimpleRepoGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

public class _SimpleRepoGenUtil {

    public static SimpleRepoGen getGen() {
        return (SimpleRepoGen) SdsmCtx.getInstance().getCurrGen();
    }

    public static SimpleRepoGenModel getModel() {
        return ((SimpleRepoGen) SdsmCtx.getInstance().getCurrGen()).getModel();
    }
    
}
