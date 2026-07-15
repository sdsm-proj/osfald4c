package pl.org.opi.util.ai.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.util.ai.api.UniAiException;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j
public class LlmOpenAiClient implements LlmClient {

    static public final String API_URL = "https://api.openai.com/v1/chat/completions";
    static public final double TEMPERATURE = 0.1;
    static public final String ROLE = "user";
    static private String API_KEY;

    static {
        final Properties properties = new Properties();
        try (final InputStream stream = new FileInputStream(new File(System.getProperty("user.home") + "/.open-ai-key.properties"))) {
            properties.load(stream);
            API_KEY = properties.getProperty("API_KEY");
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private final ObjectMapper om = new ObjectMapper();

    public enum Ver {
        V_AI_3_5,
        V_AI_4_o,
        V_AI_4_o_mini,
        O4_MINI_2025_04_16,
        GPT_4_1_2025_04_14
    }

    private String getApiKey() {
        return API_KEY;
    }

    @Data
    public static class OpenAiPromptMessage {
        public OpenAiPromptMessage(String content) {
            this.content = content;
        }
        private String role = ROLE;
        private String content = "";
    }

    @Data
    public static class OpenAiPromptObj {
        private String model;
        private double temperature = TEMPERATURE;
        private final List<OpenAiPromptMessage> messages = new ArrayList<>();
    }

    public LlmOpenAiClient(Ver ver) {
        switch (ver) {
            case V_AI_3_5 -> { model = "gpt-3.5-turbo"; }
            case V_AI_4_o -> { model = "gpt-4o-2024-11-20"; }
            case V_AI_4_o_mini -> { model = "gpt-4o-mini-2024-07-18"; }
            case O4_MINI_2025_04_16 -> { model = "o4-mini-2025-04-16"; }
            case GPT_4_1_2025_04_14 -> { model = "gpt-4.1-2025-04-14"; }
            default -> { model = "gpt-4o-mini-2024-07-18"; }
        }
    }

    private final String model;

    @Override
    public UniAiResponse call(UniAiPrompt uniPrompt)  {
        try {
            return callCore(uniPrompt);
        } catch (Exception ex) {
            throw new UniAiException(ex);
        }
    }

    private UniAiResponse callCore(UniAiPrompt uniPrompt) throws IOException, InterruptedException {
        long t1 = System.currentTimeMillis();

        OpenAiPromptObj po = new OpenAiPromptObj();

        po.setModel(this.model);
        for(var um: uniPrompt.getParagraphs()) {
            po.getMessages().add(new OpenAiPromptMessage(um));
        }

        log.info(om.writeValueAsString(po));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Accept", "application/json; charset=utf-8")
                .header("Authorization", "Bearer " + getApiKey())
                .POST(HttpRequest.BodyPublishers.ofString(om.writeValueAsString(po)))
                .build();

        HttpResponse<String> response = null;
        try (var client = HttpClient.newHttpClient()) {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }

        long t2 = System.currentTimeMillis();
        long tdiff = t2 - t1;
        double td2 = (double) tdiff / 1000;
        System.out.println("%%%%%%%%%%%%%%%%%%% Czas wywołania LLM: " + td2);

        return prepareResponse(response);
    }

    private UniAiResponse prepareResponse(HttpResponse<String> response) throws JsonProcessingException {
        if (response == null) {
            throw new UniAiException("Empty response");
        }
        JsonNode node = om.readTree(response.body());
        JsonNode choices = node.get("choices");
        JsonNode choice0 = choices.get(0);
        JsonNode content0 = choice0.get("message").get("content");
        return new UniAiResponse(content0.textValue());
    }

}
