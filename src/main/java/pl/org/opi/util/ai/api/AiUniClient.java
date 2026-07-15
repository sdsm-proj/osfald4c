package pl.org.opi.util.ai.api;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.util.ai.impl.*;

import static pl.org.opi.util.ai.impl.LlmOpenAiClient.Ver.*;

@Slf4j
public class AiUniClient {

    public static UniAiResponse call(UniAiPrompt prompt, EnumLLM vllm) throws UniAiException {
        log.info("---------------------------------------------------------------------------------------------------");
        //log.info("" + vllm);
        log.info("---------------------------------------------------------------------------------------------------");
        log.info(prompt.getEntire());
        log.info("---------------------------------------------------------------------------------------------------");

        switch (vllm) {
            case CODE_LLAMA -> {
                LlmClient llm = new LlmLlamaClient(LlmLlamaClient.Ver.V_CODELLAMA);
                return llm.call(prompt);
            }
            case QWEN_2_5_CODER -> {
                LlmClient llm = new LlmLlamaClient(LlmLlamaClient.Ver.V_QWEN);
                return llm.call(prompt);
            }
            case OPEN_AI_3_5 -> {
                LlmClient llm = new LlmOpenAiClient(LlmOpenAiClient.Ver.V_AI_3_5);
                return llm.call(prompt);
            }
            case OPEN_AI_4_o -> {
                LlmClient llm = new LlmOpenAiClient(LlmOpenAiClient.Ver.V_AI_4_o);
                return llm.call(prompt);
            }
            case OPEN_AI_4_o_mini -> {
                LlmClient llm = new LlmOpenAiClient(V_AI_4_o_mini);
                return llm.call(prompt);
            }

            case O4_MINI_2025_04_16 -> {
                LlmClient llm = new LlmOpenAiClient(O4_MINI_2025_04_16);
                return llm.call(prompt);
            }
            case GPT_4_1_2025_04_14 -> {
                LlmClient llm = new LlmOpenAiClient(GPT_4_1_2025_04_14);
                return llm.call(prompt);
            }

            case DEEPSEEK -> {
                LlmClient llm = new LlmOpiDeepseekClient(LlmOpiDeepseekClient.Ver.V_DEEPSEEK);
                return llm.call(prompt);
            }
            case PLLUM -> {
                LlmClient llm = new LlmOpiPllumClient(LlmOpiPllumClient.Ver.V_PLLUM);
                return llm.call(prompt);
            }
        }
        throw new UniAiException("Not found LLM: " + vllm);
    }

}
