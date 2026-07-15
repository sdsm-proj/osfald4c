package pl.org.opi.sdsm.app.zestawienie_a;

import pl.org.opi.sdsm.app.zestawienie_a.model.ZestawienieAGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

public class _ZestawienieAUtil {

    public static ZestawienieAGen getGen() {
        return (ZestawienieAGen) SdsmCtx.getInstance().getCurrGen();
    }

    public static ZestawienieAGenModel getModel() {
        return ((ZestawienieAGen) SdsmCtx.getInstance().getCurrGen()).getModel();
    }

}
