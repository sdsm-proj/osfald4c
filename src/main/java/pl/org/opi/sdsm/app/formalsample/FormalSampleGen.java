package pl.org.opi.sdsm.app.formalsample;

import pl.org.opi.sdsm.app.formalsample.model.FormalSampleGenModel;
import pl.org.opi.sdsm.app.formalsample.stru.configPhase.ConfigPhase;
import pl.org.opi.sdsm.app.formalsample.stru.editPhase.EditPhase;
import pl.org.opi.sdsm.app.formalsample.stru.extractPhase.ExtractPhase;
import pl.org.opi.sdsm.app.formalsample.stru.generatePhase.GeneratePhase;
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
        return true;
    }
    @Override
    public Phase createPhaseView(EnumPhase phase) {
        return switch (phase) {
            case CONFIG -> new ConfigPhase();
            case EXTRACT -> new ExtractPhase();
            case EDIT -> new EditPhase();
            case GENERATE -> new GeneratePhase();
        };
    }
}
