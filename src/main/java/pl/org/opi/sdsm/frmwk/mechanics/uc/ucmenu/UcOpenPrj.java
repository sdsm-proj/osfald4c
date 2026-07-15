package pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.gen.Gen;
import pl.org.opi.sdsm.frmwk.mechanics.prjFactory.PrjFactory;
import pl.org.opi.sdsm.frmwk.mechanics.uc.refresh.UcRefreshUi;
import pl.org.opi.sdsm.frmwk.mechanics.uc.system.UcSaveOpenPrj;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class UcOpenPrj {

    public UcOpenPrj(String prjFullFileName) {
        this.prjFullFileName = prjFullFileName;
    }
    
    private final String prjFullFileName;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() {
        new UcClosePrj().exec();
        Gen gen = PrjFactory.openPrj(prjFullFileName);
        SdsmCtx.getInstance().setCurrGen(gen);
        new UcRefreshUi().exec();
        new UcSaveOpenPrj().exec();
    }
    
}
