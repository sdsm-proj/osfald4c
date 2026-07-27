package pl.org.opi.sdsm.app.formalsample.oper.extractPhase;

import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.formalsample._FormalSampleGenUtil;
import pl.org.opi.sdsm.app.formalsample.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;
import pl.org.opi.util.ai.api.AiUniClient;
import pl.org.opi.util.ai.api.EnumLLM;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoadTablesOp {
    public void exec(ExtractViewPanel viewPanel) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("_sql_", FileUtils.readFileToString(new File(_FormalSampleGenUtil.getModel().getConfigModel().getNazwaPlikuSql())));
            VelTempl t = new VelTempl("app/formalsample/LoadTables.vm", params);
            UniAiPrompt prompt = new UniAiPrompt();
            prompt.addParagraph(t.build());
            UniAiResponse response = AiUniClient.call(prompt, EnumLLM.OPEN_AI_4_o_mini);
            String[] answer = response.getFullAnswer().split("\\r\\n|\\r|\\n");
            viewPanel.getListTablesModel().clear();
            viewPanel.getListTablesModel().addAll(Arrays.asList(answer));
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }
}
