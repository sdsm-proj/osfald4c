package pl.org.opi.sdsm.app.jsde01;

import pl.org.opi.sdsm.app.jsde01.model.Jsde01GenModel;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.BaseGenDef;

public class Jsde01GenDef extends BaseGenDef {

    public static final String CODE = "JSDE01";

    public Jsde01GenDef() {
        super(CODE, "Jsde Generator #01",
                Jsde01Gen.class, Jsde01GenModel.class,
                "pom.xml");
    }

}
