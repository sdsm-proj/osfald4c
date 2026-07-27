package pl.org.opi.sdsm.app.formalsample.oper.generatePhase;

import pl.org.opi.sdsm.app.formalsample._FormalSampleGenUtil;
import pl.org.opi.sdsm.app.formalsample.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;
import pl.org.opi.util.ai.api.AiUniClient;
import pl.org.opi.util.ai.api.EnumLLM;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

import java.util.HashMap;
import java.util.Map;

public class GenOp {
    public void exec(GenerateViewPanel viewPanel) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("_fields_", _FormalSampleGenUtil.getModel().getFinalModel().getFields());
            params.put("_tableName_", _FormalSampleGenUtil.getModel().getFinalModel().getTableName());
            VelTempl t = new VelTempl("app/formalsample/Gen.vm", params);
            UniAiPrompt prompt = new UniAiPrompt();
            prompt.addParagraph(t.build());
            UniAiResponse response = AiUniClient.call(prompt, EnumLLM.OPEN_AI_4_o_mini);
            String answer = response.getFullAnswer();
            viewPanel.getTaSrcCode().setText(answer);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }
}
