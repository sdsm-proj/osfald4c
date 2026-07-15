package pl.org.opi.sdsm.app.zestawienie_a.oper.extractPhase;

import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.zestawienie_a._ZestawienieAUtil;
import pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase.ui.ZaExtractViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import java.io.IOException;

@RequiredArgsConstructor
public class GotoEditOper {

    private final ZaExtractViewPanel viewPanel;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() throws IOException {
        _ZestawienieAUtil.getModel().getExtractModel().setSelectedEndpoint(((String)viewPanel.getComboEndpoints().getSelectedItem()));
        _ZestawienieAUtil.getModel().getExtractModel().setSelectedColumns(viewPanel.getTaColumns().getText().trim());
    }

}
