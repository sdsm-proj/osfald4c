package pl.org.opi.sdsm.app.zestawienie_a.oper.extractPhase;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.frontenddto.FRONTEND_DTO;
import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.app.zestawienie_a.ZESTAWIENIE_A;
import pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase.ui.ComboItem;
import pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase.ui.ZaExtractViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;
import pl.org.opi.util.ai.api.AiUniClient;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@RequiredArgsConstructor
public class FindEndpointsOper {

    private final ZaExtractViewPanel viewPanel;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("class_src", FileUtils.readFileToString(((ComboItem)viewPanel.getComboCtrl().getSelectedItem()).getJavaFile(), UTF_8));
        VelTempl t = new VelTempl("zestawienie_a/FindEndpointsOper.vm", params);
        String promptMessage = t.build();

        UniAiPrompt prompt = new UniAiPrompt();
        prompt.addParagraph(promptMessage);

        UniAiResponse response = AiUniClient.call(prompt, ZESTAWIENIE_A.LLM);
        String answer = response.getFullAnswer();

        viewPanel.getComboEndpoints().removeAllItems();
        String endpoints[] = answer.split(",");
        for(String ep: endpoints) {
            viewPanel.getComboEndpoints().addItem(ep.trim());
        }

        int dbg1 = 1;
    }

}
