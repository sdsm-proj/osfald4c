package pl.org.opi.sdsm.app.zestawienie_a.oper.generatePhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.zestawienie_a.ZESTAWIENIE_A;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.util.ai.api.AiUniClient;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

@RequiredArgsConstructor
public class TsDoItOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            UniAiPrompt prompt = new UniAiPrompt();
            prompt.addParagraph(stepPanel.getTextPane1().getText());
            UniAiResponse response = AiUniClient.call(prompt, ZESTAWIENIE_A.LLM);
            //String answer = response.getFullAnswer();
            String answer = response.getTypeScriptFirstChunk();
            stepPanel.getTextPane2().setText(answer);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
