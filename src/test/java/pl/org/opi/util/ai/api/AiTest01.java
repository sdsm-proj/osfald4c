package pl.org.opi.util.ai.api;

import org.junit.jupiter.api.Test;

public class AiTest01 {

    @Test
    public void test01() {

        UniAiPrompt prompt = new UniAiPrompt();

        prompt.addParagraph("cześć");
        prompt.addParagraph("czy ta deklaracja jest poprawna?");
        prompt.addParagraph("private Stringg a;", ConstaProgLang.BAQ3_JAVA);
        prompt.addParagraph("jeśli nie, podaj poprawną");

        UniAiResponse response = AiUniClient.call(prompt, EnumLLM.CODE_LLAMA);
        //UniAiResponse response = AiUniClient.call(prompt, EnumLLM.OPEN_AI_3_5);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(response.getJavaFirstChunk());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

//        for(var c: response.getJavaChunks()) {
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            System.out.println(c);
//        }
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        int dbg = 1;
    }

}
