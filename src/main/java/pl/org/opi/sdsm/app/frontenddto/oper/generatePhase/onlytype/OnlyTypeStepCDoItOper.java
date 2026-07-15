package pl.org.opi.sdsm.app.frontenddto.oper.generatePhase.onlytype;

import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.frontenddto.FRONTEND_DTO;
import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.util.ai.api.AiUniClient;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

@RequiredArgsConstructor
public class OnlyTypeStepCDoItOper {

    private final StepPanel stepPanel;

    public void exec() {
        try {
            UniAiPrompt prompt = new UniAiPrompt();
            prompt.addParagraph(stepPanel.getTextPane1().getText());
            UniAiResponse response = AiUniClient.call(prompt, FRONTEND_DTO.LLM);
            //String answer = response.getFullAnswer();
            String answer = response.getTypeScriptFirstChunk();
            stepPanel.getTextPane2().setText(answer);
            _FrontendDtoGenUtil.getModel().getGenVars().setDtoTypeName(answer.trim());
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
