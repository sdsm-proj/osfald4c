package pl.org.opi.sdsm.app.frontenddto;

import pl.org.opi.sdsm.app.frontenddto.model.FrontendDtoModel;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.BaseGenDef;

public class FrontendDtoGenDef extends BaseGenDef {

    public static final String CODE = "FRONTEND_DTO";

    public FrontendDtoGenDef() {
        super(CODE, "Frontend Dto Generator #01",
                FrontendDtoGen.class, FrontendDtoModel.class,
                "package.json");
    }

}
