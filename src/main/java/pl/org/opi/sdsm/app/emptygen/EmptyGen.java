package pl.org.opi.sdsm.app.emptygen;

import pl.org.opi.sdsm.app.emptygen.model.EmptyGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.gen.BaseGen;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public class EmptyGen extends BaseGen {

    @Override
    public EmptyGenModel getModel() {
        return (EmptyGenModel) super.getModel();
    }

    @Override
    public boolean readyToShowPhase(EnumPhase phase) {
        return true;
    }

    @Override
    public Phase createPhaseView(EnumPhase phase) {
//        switch(phase) {
//            case EDIT:
//                return new EditPhase();
//        }
        return null;
    }

}
