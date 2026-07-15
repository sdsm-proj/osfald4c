package pl.org.opi.sdsm.app.zestawienie_a;

import pl.org.opi.sdsm.app.zestawienie_a.model.ZestawienieAGenModel;
import pl.org.opi.sdsm.app.zestawienie_a.stru.configPhase.ZaConfigPhase;
import pl.org.opi.sdsm.app.zestawienie_a.stru.editPhase.ZaEditPhase;
import pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase.ZaExtractPhase;
import pl.org.opi.sdsm.app.zestawienie_a.stru.generatePhase.ZaGeneratePhase;
import pl.org.opi.sdsm.frmwk.mechanics.gen.BaseGen;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public class ZestawienieAGen extends BaseGen {

    @Override
    public ZestawienieAGenModel getModel() {
        return (ZestawienieAGenModel) super.getModel();
    }

    @Override
    public boolean readyToShowPhase(EnumPhase phase) {
        return true;
    }

    @Override
    public Phase createPhaseView(EnumPhase phase) {
        switch(phase) {
            case CONFIG:
                return new ZaConfigPhase();
            case EXTRACT:
                return new ZaExtractPhase();
            case EDIT:
                return new ZaEditPhase();
            case GENERATE:
                return new ZaGeneratePhase();
        }
        return null;
    }

}
