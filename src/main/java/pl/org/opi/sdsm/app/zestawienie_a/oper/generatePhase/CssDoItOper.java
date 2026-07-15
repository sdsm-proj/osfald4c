package pl.org.opi.sdsm.app.zestawienie_a.oper.generatePhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class CssDoItOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
//            UniAiPrompt prompt = new UniAiPrompt();
//            prompt.addParagraph(stepPanel.getTextPane1().getText());
//            UniAiResponse response = AiUniClient.call(prompt, JSDE.LLM);
//            //String answer = response.getFullAnswer();
//            String answer = response.getJavaFirstChunk();
//            stepPanel.getTextPane2().setText(answer);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
