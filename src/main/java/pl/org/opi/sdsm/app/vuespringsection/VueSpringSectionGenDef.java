package pl.org.opi.sdsm.app.vuespringsection;

import pl.org.opi.sdsm.app.vuespringsection.model.VueSpringSectionGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.BaseGenDef;

public class VueSpringSectionGenDef extends BaseGenDef {

    public static final String CODE = "VUE_SPRING_SECTION_GEN";

    public VueSpringSectionGenDef() {
        super(CODE, "Vue Spring Section Generator",
                VueSpringSectionGen.class, VueSpringSectionGenModel.class,
                "pom.xml");
    }

}
