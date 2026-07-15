package pl.org.opi.util.ai.api;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UniAiPrompt {

    @Getter
    private final List<String> paragraphs = new ArrayList<>();

    public void addParagraph(String s) {
        paragraphs.add(s);
    }

    public void addParagraph(String s, String progLang) {
        paragraphs.add(progLang + "\n" + s + "\n" + progLang);
    }

    public String getEntire() {
        StringBuilder rslt = new StringBuilder();
        rslt.append("\n");
        rslt.append("\n");
        for(var p: paragraphs) {
            rslt.append(p);
            rslt.append("\n");
            rslt.append("\n");
        }
        return rslt.toString();
    }

}
