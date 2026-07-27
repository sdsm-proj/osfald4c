package pl.org.opi.sdsm.app.formalsample.oper.extractPhase;

import io.micrometer.common.util.StringUtils;
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
import java.util.HashMap;
import java.util.Map;

public class SelectTableOp {
    public void exec(ExtractViewPanel viewPanel) {
        try {
            String tableName = (String) viewPanel.getListTables().getSelectedValue();
            if (StringUtils.isBlank(tableName)) {
                return;
            }
            Map<String, Object> params = new HashMap<>();
            params.put("_sql_", FileUtils.readFileToString(new File(_FormalSampleGenUtil.getModel().getConfigModel().getNazwaPlikuSql())));
            params.put("_tableName_", tableName);
            VelTempl t = new VelTempl("app/formalsample/SelectTable.vm", params);
            UniAiPrompt prompt = new UniAiPrompt();
            prompt.addParagraph(t.build());
            UniAiResponse response = AiUniClient.call(prompt, EnumLLM.OPEN_AI_4_o_mini);
            String answer = response.getFullAnswer();
            viewPanel.getTaFieldsExtracted().setText(answer);
            _FormalSampleGenUtil.getModel().getRawModel().setTableName(tableName);
            _FormalSampleGenUtil.getModel().getRawModel().setFields(answer);
            _FormalSampleGenUtil.getGen().save();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }
}
