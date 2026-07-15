package pl.org.opi.util.ai.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import pl.org.opi.util.ai.api.UniAiException;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LlmLlamaClient implements LlmClient {

    //static public final String API_URL = "http://localhost:11434/api/generate";
    static public final String API_URL = "http://192.168.57.235:11434/api/generate";
    static public final double TEMPERATURE = 0.01;
    static public final int MAX_TOKENS = 5000;
    static private final String BEARER = "EMPTY";

    private final ObjectMapper om = new ObjectMapper();

    public enum Ver {
        V_QWEN,
        V_CODELLAMA,
    }

    @Data
    public static class LlamaPromptObj {
        private String model;
        private double temperature = TEMPERATURE;
        //private double top_p = 1.0;
        //private double frequency_penalty = 1.0;
        //private int seed = -1;
        private int max_tokens = MAX_TOKENS;
        private boolean stream = false;
        private String prompt = "";
    }

    public LlmLlamaClient(Ver ver) {
        switch (ver) {
            //case V_QWEN -> { model = "qwen2.5-coder"; }
            //case V_CODELLAMA -> { model = "codellama"; }
            //default -> { model = "codellama"; }


            default -> { model = "deepseek-coder-v2:236b"; }
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
        LlamaPromptObj po = new LlamaPromptObj();
        po.setModel(this.model);
        po.setPrompt(uniPrompt.getEntire());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Accept", "application/json; charset=utf-8")
                //.header("Authorization", "Bearer " + BEARER)
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
        JsonNode nodeResponse = node.get("response");
        return new UniAiResponse(nodeResponse.asText());
    }

}
