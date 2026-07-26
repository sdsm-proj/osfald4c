package pl.org.opi.sdsm.app.formalsample;

import pl.org.opi.sdsm.app.formalsample.model.FormalSampleGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.gen.BaseGen;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public class FormalSampleGen extends BaseGen {
    @Override
    public FormalSampleGenModel getModel() {
        return (FormalSampleGenModel) super.getModel();
    }
    @Override
    public boolean readyToShowPhase(EnumPhase phase) {
        return false;
    }
    @Override
    public Phase createPhaseView(EnumPhase phase) {
        return null;
    }
}
