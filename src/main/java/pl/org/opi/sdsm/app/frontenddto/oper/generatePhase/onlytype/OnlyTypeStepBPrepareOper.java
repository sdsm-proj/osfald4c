package pl.org.opi.sdsm.app.frontenddto.oper.generatePhase.onlytype;

import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class OnlyTypeStepBPrepareOper {

    private final StepPanel stepPanel;

    public void exec() {
        try {
            Map<String, Object> params = new HashMap<>();

            var vars = _FrontendDtoGenUtil.getModel().getVars();
            var genVars = _FrontendDtoGenUtil.getModel().getGenVars();
            params.put("dtoTypeName", genVars.getDtoTypeName());
            params.put("dtoProps", genVars.getDtoProps());
            params.put("dtoPropsSchema", genVars.getDtoPropsSchema());
            params.put("dto_src", vars.getSelectedDto().getSourceText());
            VelTempl t = new VelTempl("frontenddto/InterfaceStepBPrepare.vmx", params);
            String promptMessage = t.build();
            stepPanel.getTextPane1().setText(promptMessage);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
