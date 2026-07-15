package pl.org.opi.sdsm.app.zestawienie_a.oper.generatePhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class CssPrepareOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
//            Map<String, Object> params = new HashMap<>();
//
//            params.put("patternInfraAddVoClass", _Jsde01GenUtil.getModel().getConfigModel().getPatternInfraAddVoClass());
//            params.put("genInfraAddVoClass", _Jsde01GenUtil.getModel().getConfigModel().getGenInfraAddVoClass());
//            params.put("genInfraAddVoPackage", _Jsde01GenUtil.getModel().getConfigModel().getGenInfraAddVoPackage());
//            params.put("genAppEntityIdClass", _Jsde01GenUtil.getModel().getConfigModel().getGenAppEntityIdClass());
//
//            params.put("java_pattern", FileUtils.readFileToString(new File(
//                    _Jsde01GenUtil.getModel().getConfigModel().getPatternInfraAddVoFullFile()
//            ), UTF_8));
//            params.put("java_AppDtoDtoClass", FileUtils.readFileToString(new File(
//                    _Jsde01GenUtil.getModel().getConfigModel().getGenAppDtoDtoFullFile()
//            ), UTF_8));
//
//            VelTempl t = new VelTempl("jsde01/generate/InfraAddVoPrepare.vm", params);
//            String promptMessage = t.build();
//            stepPanel.getTextPane1().setText(promptMessage);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
