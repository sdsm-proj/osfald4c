package pl.org.opi.sdsm.app.vuespringsection;

import pl.org.opi.sdsm.app.vuespringsection.model.VueSpringSectionGenModel;
import pl.org.opi.sdsm.app.vuespringsection.stru.configPhase.ConfigPhase;
import pl.org.opi.sdsm.app.vuespringsection.stru.extractPhase.ExtractPhase;
import pl.org.opi.sdsm.app.vuespringsection.stru.generatePhase.GeneratePhase;
import pl.org.opi.sdsm.frmwk.mechanics.gen.BaseGen;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public class VueSpringSectionGen extends BaseGen  {

    @Override
    public VueSpringSectionGenModel getModel() {
        return (VueSpringSectionGenModel) super.getModel();
    }

    @Override
    public boolean readyToShowPhase(EnumPhase phase) {
        return true;
    }

    @Override
    public Phase createPhaseView(EnumPhase phase) {
        switch(phase) {
            case CONFIG:
                return new ConfigPhase();
            case EXTRACT:
                return new ExtractPhase();
            case GENERATE:
                return new GeneratePhase();
        }
        return null;
    }

}
