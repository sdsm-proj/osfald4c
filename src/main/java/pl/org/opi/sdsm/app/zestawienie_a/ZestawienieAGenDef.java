package pl.org.opi.sdsm.app.zestawienie_a;

import pl.org.opi.sdsm.app.zestawienie_a.model.ZestawienieAGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.BaseGenDef;

public class ZestawienieAGenDef extends BaseGenDef {

    public static final String CODE = "ZESTAWIENIE_A_GEN";

    public ZestawienieAGenDef() {
        super(CODE, "Zestawienie A Generator",
                ZestawienieAGen.class, ZestawienieAGenModel.class,
                "package.json");
    }

}
