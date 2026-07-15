package pl.org.opi.sdsm.frmwk.mechanics.uc.refresh;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.gen.Gen;
import pl.org.opi.sdsm.frmwk.mechanics.uc.mainwindow.UcClearView;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class UcRefreshUi {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }
  
    private void execCore() {
        refreshTitle();
        refreshStatusBar();
        refreshMainPanel();
    }
    
    //--------------------------------------------------------------------------
    
    private void refreshTitle() {
        String title = "SDSM Osfald";
        Gen gen = SdsmCtx.getInstance().getCurrGen();
        if (gen != null) {
            title += " :: " + gen.getModel().getCode();
            title += " :: " + gen.getModel().getPrjShortName();
        }
        AppCtx.getInstance().getMainWindow().setTitle(title);
    }
    
    private void refreshStatusBar() {
        String statusBar = " ";
        Gen gen = SdsmCtx.getInstance().getCurrGen();
        if (gen != null) {
            statusBar += gen.getModel().getPrjFullFileName();
        }
        AppCtx.getInstance().getMainWindow().getLabelPrj().setText(statusBar);
    }
    
    private void refreshMainPanel() {
        Gen gen = SdsmCtx.getInstance().getCurrGen();
        if (gen == null) {
            new UcClearView().exec();
        }
    }
    
}
