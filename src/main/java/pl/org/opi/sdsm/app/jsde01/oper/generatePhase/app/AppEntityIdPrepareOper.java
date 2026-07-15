package pl.org.opi.sdsm.app.jsde01.oper.generatePhase.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.jsde01._Jsde01GenUtil;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@RequiredArgsConstructor
public class AppEntityIdPrepareOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("patternAppEntityIdClass", _Jsde01GenUtil.getModel().getConfigModel().getPatternAppEntityIdClass());
            params.put("genAppEntityIdClass", _Jsde01GenUtil.getModel().getConfigModel().getGenAppEntityIdClass());
            params.put("genAppEntityIdPackage", _Jsde01GenUtil.getModel().getConfigModel().getGenAppEntityIdPackage());
            params.put("java_pattern", FileUtils.readFileToString(new File(
                    _Jsde01GenUtil.getModel().getConfigModel().getPatternAppEntityIdFullFile()
            ), UTF_8));
            VelTempl t = new VelTempl("jsde01/generate/AppEntityIdPrepare.vm", params);
            String promptMessage = t.build();
            stepPanel.getTextPane1().setText(promptMessage);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
