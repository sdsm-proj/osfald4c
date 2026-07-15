package pl.org.opi.sdsm.app.zestawienie_a.oper.generatePhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.zestawienie_a._ZestawienieAUtil;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import java.io.File;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class TsSaveOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            FileUtils.write(
                    new File(_ZestawienieAUtil.getModel().getEditModel().getAngularComponentTsFullFileName()),
                    stepPanel.getTextPane2().getText().trim(),
                    StandardCharsets.UTF_8
            );
            SdsmCtx.getInstance().getCurrGen().save();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
