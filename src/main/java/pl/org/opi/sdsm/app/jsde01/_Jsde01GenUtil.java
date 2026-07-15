package pl.org.opi.sdsm.app.jsde01;

import pl.org.opi.sdsm.app.jsde01.model.Jsde01GenModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

public class _Jsde01GenUtil {

    public static Jsde01Gen getGen() {
        return (Jsde01Gen) SdsmCtx.getInstance().getCurrGen();
    }

    public static Jsde01GenModel getModel() {
        return ((Jsde01Gen) SdsmCtx.getInstance().getCurrGen()).getModel();
    }

}
