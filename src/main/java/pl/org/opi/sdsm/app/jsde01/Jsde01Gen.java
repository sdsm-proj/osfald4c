package pl.org.opi.sdsm.app.jsde01;

import pl.org.opi.sdsm.app.jsde01.model.Jsde01GenModel;
import pl.org.opi.sdsm.app.jsde01.stru.configPhase.ConfigPhase;
import pl.org.opi.sdsm.app.jsde01.stru.editPhase.EditPhase;
import pl.org.opi.sdsm.app.jsde01.stru.extractPhase.ExtractPhase;
import pl.org.opi.sdsm.app.jsde01.stru.generatePhase.GeneratePhase;
import pl.org.opi.sdsm.frmwk.mechanics.gen.BaseGen;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public class Jsde01Gen extends BaseGen {

    @Override
    public Jsde01GenModel getModel() {
        return (Jsde01GenModel) super.getModel();
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
            case EDIT:
                return new EditPhase();
            case GENERATE:
                return new GeneratePhase();
        }
        return null;
    }

}
