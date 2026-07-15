package pl.org.opi.sdsm.app.simplerepo;

import pl.org.opi.sdsm.app.simplerepo.model.SimpleRepoGenModel;
import pl.org.opi.sdsm.app.simplerepo.stru.configPhase.ConfigPhase;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.EditPhase;
import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ExtractPhase;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.GeneratePhase;
import pl.org.opi.sdsm.frmwk.mechanics.gen.BaseGen;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public class SimpleRepoGen extends BaseGen {

    @Override
    public SimpleRepoGenModel getModel() {
        return (SimpleRepoGenModel) super.getModel();
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
