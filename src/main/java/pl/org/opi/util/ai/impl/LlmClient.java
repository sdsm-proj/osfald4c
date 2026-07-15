package pl.org.opi.util.ai.impl;

import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;

public interface LlmClient {
    UniAiResponse call(UniAiPrompt uniPrompt);
}

// skopiuj klasę

