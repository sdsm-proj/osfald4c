package pl.org.opi.util.ai.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.util.ai.api.UniAiException;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LlmOpiClient implements LlmClient {

    //static public final String API_URL = "http://192.168.57.235:8800/v1/chat/completions"; // Plum
    static public final String API_URL = "http://192.168.57.235:8100/v1/chat/completions"; // Plum

    static public final double TEMPERATURE = 0;
    static public final int MAX_TOKENS = 5000;
    static public final String ROLE = "user";
    static private final String BEARER = "EMPTY";
    private final ObjectMapper om = new ObjectMapper();

    public enum Ver {
        OPI_LOCAL_01,
    }

//    @Data
//    @AllArgsConstructor
//    public static class OpiContent {
//        private String type;
//        private String text;
//    }

    @Data
    public static class OpiPromptMessage {
        public OpiPromptMessage(String content) {
            this.content = content;
        }
        private String role = ROLE;
        //private List<OpiContent> content = new ArrayList<>();
        private String content = "";
    }

    @Data
    public static class OpiPromptObj {
        private String model;
        //private double temperature = TEMPERATURE;
        private final List<OpiPromptMessage> messages = new ArrayList<>();
        //private final String prompt = "Why is the sky blue?";
        //private final String content = "Why is the sky blue?";
        private int max_tokens = 127;
        //private boolean stream = false;
    }


    public LlmOpiClient(Ver ver) {
        switch (ver) {
            case OPI_LOCAL_01 -> { model = "deepseek-ai/deepseek-coder-33b-instruct"; }
            default -> { model = "deepseek-ai/deepseek-coder-33b-instruct"; }
            //case OPI_LOCAL_01 -> { model = "/pllum"; }
            //default -> { model = "/pllum"; }
        }
    }

    private final String model;

    @Override
    public UniAiResponse call(UniAiPrompt uniPrompt) {
        try {
            return callCore(uniPrompt);
        } catch (Exception ex) {
            throw new UniAiException(ex);
        }
    }

    private UniAiResponse callCore(UniAiPrompt uniPrompt) throws IOException, InterruptedException {
        OpiPromptObj po = new OpiPromptObj();

        po.setModel(this.model);
        for(var um: uniPrompt.getParagraphs()) {
            //po.getMessages().add(new OpiPromptMessage(um));
            //po.getMessages().add(new OpiPromptMessage("Why is the sky blue?"));
        }
        po.getMessages().add(new OpiPromptMessage("Why is the sky blue?"));

        log.info(om.writeValueAsString(po));

        HttpRequest request = HttpRequest.newBuilder()

                .uri(URI.create(API_URL))

                .header("Content-Type", "application/json; charset=utf-8")
                //.header("Accept", "application/json; charset=utf-8")
                .header("Authorization", "Bearer " + BEARER)
                .POST(HttpRequest.BodyPublishers.ofString(om.writeValueAsString(po)))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = null;
        try (var client = HttpClient.newHttpClient()) {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }

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
