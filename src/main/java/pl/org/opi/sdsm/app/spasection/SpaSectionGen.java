package pl.org.opi.sdsm.app.spasection;

import pl.org.opi.sdsm.app.spasection.model.SpaSectionGenModel;
import pl.org.opi.sdsm.app.spasection.stru.configPhase.ConfigPhase;
import pl.org.opi.sdsm.app.spasection.stru.editPhase.EditPhase;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ExtractPhase;
import pl.org.opi.sdsm.app.spasection.stru.generatePhase.GeneratePhase;
import pl.org.opi.sdsm.frmwk.mechanics.gen.BaseGen;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

public class SpaSectionGen extends BaseGen {

    @Override
    public SpaSectionGenModel getModel() {
        return (SpaSectionGenModel) super.getModel();
    }

    @Override
    public boolean readyToShowPhase(EnumPhase phase) {
//        switch(phase) {
//            case EDIT:
//                if (getModel().getOperCache().getSelectedSectionPart() == null) {
//                    OsfaldMsgBox.warn("Select section part to edit first (SDSM Extract phase).");
//                    return false;
//                }
//        }
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
