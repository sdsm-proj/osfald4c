package pl.org.opi.sdsm.app.jsde01.oper.generatePhase.infra;

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
public class InfraRepoPrepare {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("patternInfraRepoClass", _Jsde01GenUtil.getModel().getConfigModel().getPatternInfraRepoClass());
            params.put("genInfraRepoClass", _Jsde01GenUtil.getModel().getConfigModel().getGenInfraRepoClass());
            params.put("genInfraRepoPackage", _Jsde01GenUtil.getModel().getConfigModel().getGenInfraRepoPackage());

            params.put("patternAppEntityIdClass", _Jsde01GenUtil.getModel().getConfigModel().getPatternAppEntityIdClass());
            params.put("genAppEntityIdClass", _Jsde01GenUtil.getModel().getConfigModel().getGenAppEntityIdClass());
            params.put("genAppEntityIdPackage", _Jsde01GenUtil.getModel().getConfigModel().getGenAppEntityIdPackage());

            params.put("patternEntityClass", _Jsde01GenUtil.getModel().getConfigModel().getPatternEntityClass());
            params.put("genEntityClass", _Jsde01GenUtil.getModel().getConfigModel().getGenEntityClass());
            params.put("genEntityPackage", _Jsde01GenUtil.getModel().getConfigModel().getGenEntityPackage());

            params.put("patternInfraAddVoClass", _Jsde01GenUtil.getModel().getConfigModel().getPatternInfraAddVoClass());
            params.put("genInfraAddVoClass", _Jsde01GenUtil.getModel().getConfigModel().getGenInfraAddVoClass());
            params.put("genInfraAddVoPackage", _Jsde01GenUtil.getModel().getConfigModel().getGenInfraAddVoPackage());

            params.put("java_pattern", FileUtils.readFileToString(new File(
                    _Jsde01GenUtil.getModel().getConfigModel().getPatternIInfraRepoFullFile()
            ), UTF_8));

            params.put("java_InfraAddVoClass", FileUtils.readFileToString(new File(
                    _Jsde01GenUtil.getModel().getConfigModel().getGenInfraAddVoFullFile()
            ), UTF_8));

            params.put("java_entity", FileUtils.readFileToString(new File(
                    _Jsde01GenUtil.getModel().getConfigModel().getGenEntityFullFile()
            ), UTF_8));

            VelTempl t = new VelTempl("jsde01/generate/InfraRepoPrepare.vm", params);
            String promptMessage = t.build();
            stepPanel.getTextPane1().setText(promptMessage);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
