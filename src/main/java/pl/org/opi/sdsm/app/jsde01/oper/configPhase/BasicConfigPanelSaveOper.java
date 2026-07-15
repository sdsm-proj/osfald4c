package pl.org.opi.sdsm.app.jsde01.oper.configPhase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.jsde01._Jsde01GenUtil;
import pl.org.opi.sdsm.app.jsde01.model.config.ConfigModel;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class BasicConfigPanelSaveOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            String s1 = stepPanel.getTextPane1().getText();
            ConfigModel configModel = om.readValue(s1, ConfigModel.class);
            _Jsde01GenUtil.getModel().setConfigModel(configModel);
            String s2 = om.writerWithDefaultPrettyPrinter().writeValueAsString(configModel);
            stepPanel.getTextPane2().setText(s2);

            SdsmCtx.getInstance().getCurrGen().save();
        } catch (JsonProcessingException ex) {
            OsfaldMsgBox.error(ex);
        }

    }

}
