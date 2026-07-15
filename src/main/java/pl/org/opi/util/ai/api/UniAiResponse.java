package pl.org.opi.util.ai.api;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UniAiResponse {

    private final String response;

    public String getFullAnswer() {
        return response;
    }

    public String getJavaFirstChunk() {
        var chunks = getJavaChunks();
        if (!chunks.isEmpty()) {
            return chunks.getFirst();
        }
        return "";
    }

    public String getGraphQLFirstChunk() {
        var chunks = getGraphQLChunks();
        if (!chunks.isEmpty()) {
            return chunks.getFirst();
        }
        return "";
    }

    public String getSQLFirstChunk() {
        var chunks = getSQLChunks();
        if (!chunks.isEmpty()) {
            return chunks.getFirst();
        }
        return "";
    }

    public String getTypeScriptFirstChunk() {
        var chunks = getTypeScriptChunks();
        if (!chunks.isEmpty()) {
            return chunks.getFirst();
        }
        return "";
    }

    public String getHtmlFirstChunk() {
        var chunks = getHtmlChunks();
        if (!chunks.isEmpty()) {
            return chunks.getFirst();
        }
        return "";
    }


    public List<String> getJavaChunks() {
        return getCodeChunks(ConstaProgLang.JAVA);
    }

    public List<String> getGraphQLChunks()  {
        return getCodeChunks(ConstaProgLang.GRAPHQL);
    }

    public List<String> getSQLChunks()  {
        return getCodeChunks(ConstaProgLang.SQL);
    }

    public List<String> getTypeScriptChunks()  {
        return getCodeChunks(ConstaProgLang.TYPE_SCRIPT);
    }

    public List<String> getHtmlChunks()  {
        return getCodeChunks(ConstaProgLang.HTML);
    }


    private List<String> getCodeChunks(String progLang) {
        List<String> rslt = new ArrayList<>();
        appendBetween(progLang, rslt); // Np. Sql
        if (!progLang.equals(progLang.toUpperCase())) appendBetween(progLang.toUpperCase(), rslt); // Np. SQL
        if (!progLang.equals(progLang.toLowerCase())) appendBetween(progLang.toLowerCase(), rslt); // Np. sql
        return rslt;
    }

    private void appendBetween(String progLang, List<String> rslt) {
        String[] subs = StringUtils.substringsBetween(getFullAnswer(), ConstaProgLang.BAQ3 + progLang, ConstaProgLang.BAQ3);
        if (subs != null) {
            if (subs.length > 0) {
                for (String s : subs) {
                    s = StringUtils.removeStart(s, progLang);
                    s = StringUtils.removeEnd(s, progLang);
                    s = s.trim();
                    s = StringUtils.removeStart(s, "\n");
                    s = StringUtils.removeEnd(s, "\n");
                    s = s.trim();
                    rslt.add(s);
                }
            }
        }
    }

}
