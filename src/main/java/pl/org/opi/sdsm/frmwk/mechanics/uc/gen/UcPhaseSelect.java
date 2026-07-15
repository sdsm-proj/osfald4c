package pl.org.opi.sdsm.frmwk.mechanics.uc.gen;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.gen.Gen;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class UcPhaseSelect {
    
    public void exec(EnumPhase phase) {
        try {
            execCore(phase);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore(EnumPhase phase) {
        Gen gen = SdsmCtx.getInstance().getCurrGen();
        if (gen == null) return;
        if (gen.readyToShowPhase(phase)) {
            if (gen.canCloseCurrPhase()) {
                if (gen.showPhase(phase)) {
                    AppCtx.getInstance().getMainWindow().getLabelPhase().setText("Phase " + phase.toString() + " ");
                }
            }
        }
    }
    
}
