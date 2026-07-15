package pl.org.opi.sdsm.app.spasection;

import pl.org.opi.sdsm.app.spasection.model.SpaSectionGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.BaseGenDef;

public class SpaSectionGenDef extends BaseGenDef {

    public static final String CODE = "SPA_SECTION_GEN";

    public SpaSectionGenDef() {
        super(CODE, "SPA Section Generator",
                SpaSectionGen.class,
                SpaSectionGenModel.class,
                "pom.xml");
    }

}
