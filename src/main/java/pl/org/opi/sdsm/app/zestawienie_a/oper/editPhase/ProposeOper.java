package pl.org.opi.sdsm.app.zestawienie_a.oper.editPhase;

import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.zestawienie_a._ZestawienieAUtil;
import pl.org.opi.sdsm.app.zestawienie_a.stru.editPhase.ui.ZaEditViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class ProposeOper {

    private final ZaEditViewPanel viewPanel;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() throws Exception {
        var em = _ZestawienieAUtil.getModel().getEditModel();

        viewPanel.getEdAngularComponentPath().setText(_ZestawienieAUtil.getModel().getPrjRootPath());

    }


}
