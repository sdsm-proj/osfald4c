package pl.org.opi.sdsm.app.simplerepo;

import pl.org.opi.sdsm.app.simplerepo.model.SimpleRepoGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.BaseGenDef;

public class SimpleRepoGenDef extends BaseGenDef {
    public static final String CODE = "SIMPLE_REPO";

    public SimpleRepoGenDef() {
        super(CODE, "Simple Repository Generator",
                SimpleRepoGen.class, SimpleRepoGenModel.class,
                "pom.xml");
    }
}
