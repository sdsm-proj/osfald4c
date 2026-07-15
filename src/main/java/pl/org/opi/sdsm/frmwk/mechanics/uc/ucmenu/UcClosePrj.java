package pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.uc.refresh.UcRefreshUi;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class UcClosePrj {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() {
        SdsmCtx.getInstance().setCurrGen(null);
        new UcRefreshUi().exec();
    }
    
}
