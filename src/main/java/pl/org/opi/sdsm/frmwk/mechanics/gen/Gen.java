package pl.org.opi.sdsm.frmwk.mechanics.gen;

import pl.org.opi.sdsm.frmwk.mechanics.gendef.GenDef;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public interface Gen {
    
    GenDef getDef();
    
    BaseGenModel getModel();
    
    void save();
    
    Phase getCurrPhaseView();
    
    boolean canCloseCurrPhase();
    
    boolean readyToShowPhase(EnumPhase phase);

    boolean showPhase(EnumPhase phase);
    
    Phase createPhaseView(EnumPhase phase);
    
}
