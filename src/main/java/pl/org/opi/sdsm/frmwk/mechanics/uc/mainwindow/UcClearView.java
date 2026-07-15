package pl.org.opi.sdsm.frmwk.mechanics.uc.mainwindow;

import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.sdsm.frmwk.mechanics.MainWindow;

public class UcClearView {
    
    public void exec() {
        MainWindow mw = AppCtx.getInstance().getMainWindow();
        mw.getPanelMain().removeAll();
        mw.getRootPane().updateUI();
        mw.getLabelPhase().setText("");
    }
    
}
