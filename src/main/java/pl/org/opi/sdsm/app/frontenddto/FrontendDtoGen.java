package pl.org.opi.sdsm.app.frontenddto;

import pl.org.opi.sdsm.app.frontenddto.model.FrontendDtoModel;
import pl.org.opi.sdsm.app.frontenddto.stru.extractPhase.FdExtractPhase;
import pl.org.opi.sdsm.app.frontenddto.stru.generatePhase.FdGeneratePhase;
import pl.org.opi.sdsm.frmwk.mechanics.gen.BaseGen;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public class FrontendDtoGen extends BaseGen {

    @Override
    public FrontendDtoModel getModel() {
        return (FrontendDtoModel) super.getModel();
    }

    @Override
    public boolean readyToShowPhase(EnumPhase phase) {
        return true;
    }

    @Override
    public Phase createPhaseView(EnumPhase phase) {
        switch(phase) {
            case CONFIG:
            case EXTRACT:
                return new FdExtractPhase();
            case EDIT:
            case GENERATE:
                return new FdGeneratePhase();
        }
        return null;
    }


}

