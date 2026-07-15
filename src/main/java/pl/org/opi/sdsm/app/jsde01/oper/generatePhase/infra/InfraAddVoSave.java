package pl.org.opi.sdsm.app.jsde01.oper.generatePhase.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.jsde01._Jsde01GenUtil;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import java.io.File;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class InfraAddVoSave {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            FileUtils.write(
                    new File(_Jsde01GenUtil.getModel().getConfigModel().getGenInfraAddVoFullFile()),
                    stepPanel.getTextPane2().getText().trim(),
                    StandardCharsets.UTF_8
            );
            SdsmCtx.getInstance().getCurrGen().save();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
