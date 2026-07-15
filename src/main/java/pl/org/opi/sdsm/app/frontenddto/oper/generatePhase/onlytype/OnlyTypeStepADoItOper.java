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
public class OnlyTypeStepADoItOper {

    private final StepPanel stepPanel;

    public void exec() {
        try {
            UniAiPrompt prompt = new UniAiPrompt();
            prompt.addParagraph(stepPanel.getTextPane1().getText());
            UniAiResponse response = AiUniClient.call(prompt, FRONTEND_DTO.LLM);
            String answer = response.getFullAnswer();
            //String answer = response.getTypeScriptFirstChunk();
            stepPanel.getTextPane2().setText(answer);
            var genVars = _FrontendDtoGenUtil.getModel().getGenVars();

            genVars.setDtoTypeName(answer.trim());

            if (genVars.getDtoTypeName().toLowerCase().endsWith("dto")) {
                genVars.setPureTypeName(genVars.getDtoTypeName().substring(0, genVars.getDtoTypeName().length() - 3));
            }

            genVars.setDtoProps(genVars.getDtoTypeName() + "Props");
            genVars.setDtoPropsSchema(genVars.getDtoTypeName() + "PropsSchema");
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
