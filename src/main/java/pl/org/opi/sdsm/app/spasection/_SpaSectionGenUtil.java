package pl.org.opi.sdsm.app.spasection;

import pl.org.opi.sdsm.app.spasection.model.SpaSectionGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

public class _SpaSectionGenUtil {

    public static SpaSectionGen getGen() {
        return (SpaSectionGen) SdsmCtx.getInstance().getCurrGen();
    }

    public static SpaSectionGenModel getModel() {
        return ((SpaSectionGen) SdsmCtx.getInstance().getCurrGen()).getModel();
    }

}
