package pl.org.opi.sdsm.app.spasection.oper.extractPhase;

import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

public class RefreshAction {

    private final ExtractViewPanel viewPanel;

    public RefreshAction(ExtractViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() {
        try {
            new ClearAllOper(viewPanel).exec();
            new FillClassesAndDocumentsOper(viewPanel).exec();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
