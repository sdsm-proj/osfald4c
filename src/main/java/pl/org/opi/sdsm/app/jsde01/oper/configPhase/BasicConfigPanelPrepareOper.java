package pl.org.opi.sdsm.app.jsde01.oper.configPhase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.jsde01._Jsde01GenUtil;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class BasicConfigPanelPrepareOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            String s = om.writerWithDefaultPrettyPrinter().writeValueAsString(_Jsde01GenUtil.getModel().getConfigModel());
            stepPanel.getTextPane1().setText(s);
        } catch (JsonProcessingException ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
