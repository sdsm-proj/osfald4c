package pl.org.opi.sdsm.app.spasection.oper.other;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SplitLinesCommas {

    public String[] exec(String inputStr) {
        List<String> rslt = new ArrayList<>();

        if (StringUtils.isBlank(inputStr)) {
            return new String[]{};
        }

        for(var line1: inputStr.split("\n")) {
            for(var line2: line1.split(",")) {
                for(var line3: line2.split(";")) {
                    String s = line3.trim();
                    if (StringUtils.isNotBlank(s)) {
                        if (StringUtils.isNotBlank(s.trim())) {
                            rslt.add(s.trim());
                        }
                    }
                }
            }
        }

        return rslt.toArray(String[]::new);
    }

}
