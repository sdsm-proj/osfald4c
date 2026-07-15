package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.javaai;

import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;
import pl.org.opi.util.ai.api.AiUniClient;
import pl.org.opi.util.ai.api.EnumLLM;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JavaBleBleGeneratorAI {

    public JavaBleBleGeneratorAI(EnumLLM llm) {
        this.llm = llm;
    }

    private final EnumLLM llm;

    public void exec() throws IOException {
        gen();
    }

    private void gen() throws IOException {
        Map<String, Object> params = new HashMap<>();

        VelTempl t = new VelTempl("gen/backend/javaai/JavaBlaBla01.vm", params);
        String promptMessage = t.build();

        UniAiPrompt prompt = new UniAiPrompt();
        prompt.addParagraph(promptMessage);

        UniAiResponse response = AiUniClient.call(prompt, this.llm);

        String all = "";
        all += "\n\n";
        all += "******************************************************************************";
        all += "\n\n";
        System.out.println(all);

        System.out.println(promptMessage);

        all = "";
        all += "\n\n";
        all += "******************************************************************************";
        all += "\n\n";
        all += response.getFullAnswer();
        all += "\n\n";
        all += "******************************************************************************";
        all += "\n\n";

        System.out.println(all);

        int dbg = 1;
    }

}
