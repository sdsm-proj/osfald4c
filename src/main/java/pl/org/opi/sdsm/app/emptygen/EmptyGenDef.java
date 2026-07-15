package pl.org.opi.sdsm.app.emptygen;

import pl.org.opi.sdsm.app.emptygen.model.EmptyGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.BaseGenDef;

public class EmptyGenDef extends BaseGenDef {

    public static final String CODE = "EMPTY_GEN";

    public EmptyGenDef() {
        super(CODE, "Empty Generator",
                EmptyGen.class, EmptyGenModel.class,
                "pom.xml");
    }

}
