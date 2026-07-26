package pl.org.opi.sdsm.app.formalsample;

import pl.org.opi.sdsm.app.formalsample.model.FormalSampleGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.BaseGenDef;

public class FormalSampleGenDef extends BaseGenDef {
    public static final String CODE = "FORMAL_SAMPLE";

    public FormalSampleGenDef() {
        super(CODE, "Formal Sample Generator",
                FormalSampleGen.class, FormalSampleGenModel.class,
                "pom.xml");
    }
}
