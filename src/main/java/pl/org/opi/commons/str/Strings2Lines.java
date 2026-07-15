package pl.org.opi.commons.str;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * [ "string1", "string2", "string3", "string4", "string5", "string6", "string7", "string8", "string9" ]
 *
 * =>
 *
 * "string1, string2, string3,"
 * "string4, string5, string6,"
 * "string7, string8, string9"
 */
public class Strings2Lines {

    public Strings2Lines(List<String> inputStrings, String separator, int lineMaxLen) {
        this.inputStrings = inputStrings;
        this.separator = separator;
        this.lineMaxLen = lineMaxLen;
    }

    private final List<String> inputStrings;

    private final String separator;

    private final int lineMaxLen;

    private final List<String> rsltLines = new ArrayList<>();

    public List<String> exec() {
        List<String> tmpLines = new ArrayList<>();
        String line = "";
        for(String s : inputStrings) {
            if (StringUtils.isBlank(s)) continue;
            line += s + separator + " ";
            if (line.length() > lineMaxLen) {
                tmpLines.add(line);
                line = "";
            }
        }
        if (StringUtils.isNotBlank(line)) {
            tmpLines.add(line);
        }
        for (int i = 0; i < tmpLines.size(); i++) {
            line = tmpLines.get(i);
            line = line.trim();
            if (i == (tmpLines.size() - 1)) {
                line = StringUtils.removeEnd(line, separator);
            }
            rsltLines.add(line);
        }
        return rsltLines;
    }

}
