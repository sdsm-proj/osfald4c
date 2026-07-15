package pl.org.opi.sdsm.app.jsde01.oper.extractPhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.jsde01.JSDE;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.util.ai.api.AiUniClient;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

@RequiredArgsConstructor
public class PatternTableDoItOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            UniAiPrompt prompt = new UniAiPrompt();
            prompt.addParagraph(stepPanel.getTextPane1().getText());
            UniAiResponse response = AiUniClient.call(prompt, JSDE.LLM);
            //String answer = response.getFullAnswer();
            String answer = response.getSQLFirstChunk();
            stepPanel.getTextPane2().setText(answer);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
