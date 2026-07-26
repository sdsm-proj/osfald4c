package pl.org.opi.sdsm.app.formalsample;

import pl.org.opi.sdsm.app.formalsample.model.FormalSampleGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

public class _FormalSampleGenUtil {
    public static FormalSampleGen getGen() {
        return (FormalSampleGen) SdsmCtx.getInstance().getCurrGen();
    }
    public static FormalSampleGenModel getModel() {
        return ((FormalSampleGen) SdsmCtx.getInstance().getCurrGen()).getModel();
    }
}
