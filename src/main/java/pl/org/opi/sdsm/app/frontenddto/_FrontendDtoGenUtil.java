package pl.org.opi.sdsm.app.frontenddto;

import pl.org.opi.sdsm.app.frontenddto.model.FrontendDtoModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

public class _FrontendDtoGenUtil {

    public static FrontendDtoGen getGen() {
        return (FrontendDtoGen) SdsmCtx.getInstance().getCurrGen();
    }

    public static FrontendDtoModel getModel() {
        return ((FrontendDtoGen) SdsmCtx.getInstance().getCurrGen()).getModel();
    }

}
