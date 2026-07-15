package pl.org.opi.sdsm.app.frontenddto.oper.generatePhase.iface;

import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class InterfaceStepAPrepareOper {

    private final StepPanel stepPanel;

    public void exec() {
        try {
            Map<String, Object> params = new HashMap<>();

            var selDto = _FrontendDtoGenUtil.getModel().getVars().getSelectedDto();
            params.put("dto_src", selDto.getSourceText());
            VelTempl t = new VelTempl("frontenddto/InterfaceStepAPrepare.vm", params);
            String promptMessage = t.build();
            stepPanel.getTextPane1().setText(promptMessage);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
