package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen;

import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.graphql2ai.InputGraphQLGeneratorAi;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.javaai.JavaBleBleGeneratorAI;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.javaai.JavaInputGeneratorAi;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.javaai.JavaServiceImplGeneratorAi;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.util.ai.api.EnumLLM;

import java.io.IOException;
import java.util.Date;

public class GenerateBackendAiOper {

    public void exec() {
        try {
            execCore();
        } catch (IOException ex) {
            throw new OsfaldRuntimeException(ex.getMessage(), ex);
        }
    }

    private void execCore() throws IOException {
        // ABCH
        //EnumLLM llm = EnumLLM.CODE_LLAMA;
        //EnumLLM llm = EnumLLM.QWEN_2_5_CODER;
        //EnumLLM llm = EnumLLM.OPEN_AI_3_5;
        EnumLLM llm = EnumLLM.OPEN_AI_4_o_mini;
        //EnumLLM llm = EnumLLM.DEEPSEEK;
        //EnumLLM llm = EnumLLM.PLLUM;

        for(int i = 0; i < 5; i++) {
            System.out.println(" Start ************************************************************************************");
        }
        System.out.println(new Date());


        new JavaInputGeneratorAi(llm).exec();
        new InputGraphQLGeneratorAi(llm).exec();
        new JavaServiceImplGeneratorAi(llm).exec();

        //new JavaBleBleGeneratorAI(llm).exec();

        for(int i = 0; i < 5; i++) {
            System.out.println(" Qńc ************************************************************************************");
        }
        System.out.println(new Date());

    }

}
