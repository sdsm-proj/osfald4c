package pl.org.opi.sdsm.app.frontenddto.oper.extractPhase;

import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

public class ClearSelectedDto {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() {
        _FrontendDtoGenUtil.getModel().getVars().setSelectedDto(null);
    }

}
