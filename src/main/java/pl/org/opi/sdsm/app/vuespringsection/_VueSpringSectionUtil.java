package pl.org.opi.sdsm.app.vuespringsection;

import pl.org.opi.sdsm.app.vuespringsection.model.VueSpringSectionGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

public class _VueSpringSectionUtil {

    public static VueSpringSectionGen getGen() {
        return (VueSpringSectionGen) SdsmCtx.getInstance().getCurrGen();
    }

    public static VueSpringSectionGenModel getModel() {
        return ((VueSpringSectionGen) SdsmCtx.getInstance().getCurrGen()).getModel();
    }

}
