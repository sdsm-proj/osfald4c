package pl.org.opi.sdsm.app.zestawienie_a.oper.generatePhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.zestawienie_a._ZestawienieAUtil;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class HtmlPrepareOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("field_list", _ZestawienieAUtil.getModel().getExtractModel().getSelectedColumns());
            VelTempl t = new VelTempl("zestawienie_a/HtmlPrepareOper.vm", params);
            String promptMessage = t.build();
            stepPanel.getTextPane1().setText(promptMessage);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
