package pl.org.opi.sdsm.frmwk.mechanics.uc.gen;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class ActPhaseSelect {

    public void exec(EnumPhase phase) {
        try {
            execCore(phase);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore(EnumPhase phase) {
        new UcPhaseSelect().exec(phase);
    }
    
}
