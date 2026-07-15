package pl.org.opi.sdsm.app.frontenddto.oper.generatePhase.onlytype;

import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class OnlyTypeStepCPrepareOper {

    private final StepPanel stepPanel;

    public void exec() {
        try {
            Map<String, Object> params = new HashMap<>();

            var vars = _FrontendDtoGenUtil.getModel().getVars();
            var genVars = _FrontendDtoGenUtil.getModel().getGenVars();

            params.put("dto_src", vars.getSelectedDto().getSourceText());

            params.put("pureTypeName", genVars.getPureTypeName());
            params.put("dtoTypeName", genVars.getDtoTypeName());
            params.put("dtoProps", genVars.getDtoProps());
            params.put("dtoPropsSchema", genVars.getDtoPropsSchema());
            params.put("dto_props_src", genVars.getDtoPropsSchemaSrc());

            VelTempl t = new VelTempl("frontenddto/OnlyTypeStepCPrepare.vm", params);
            String promptMessage = t.build();
            stepPanel.getTextPane1().setText(promptMessage);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
