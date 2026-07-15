package pl.org.opi.sdsm.app.zestawienie_a.oper.configPhase;

import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.zestawienie_a._ZestawienieAUtil;
import pl.org.opi.sdsm.app.zestawienie_a.stru.configPhase.ui.ZaConfigViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class LoadOper {

    private final ZaConfigViewPanel viewPanel;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() throws Exception {
        var cm = _ZestawienieAUtil.getModel().getConfigModel();
        viewPanel.getEdPrjFrontFullPath().setText(cm.getPrjFrontFullPath());
        viewPanel.getEdPrjContractFullPath().setText(cm.getPrjContractFullPath());
        viewPanel.getEdPrjBackendFullPath().setText(cm.getPrjBackendFullPath());
        viewPanel.getEdPrjBackendGenFullPath().setText(cm.getPrjBackendGenFullPath());
    }

}
