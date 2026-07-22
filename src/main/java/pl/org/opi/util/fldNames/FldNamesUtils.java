package pl.org.opi.util.fldNames;

import com.google.common.base.CaseFormat;

public class FldNamesUtils {

    public static String firstLetterLower(String input) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, input);
    }

    public static String firstLetterUpper(String input) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, input);
    }

    public static String camelToUnderscore(String input) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, input);
    }

    public static String removeSpaces(String input) {
        return input.replace(" ", "");
    }

    public static String extractShortClassName(String fullClassName) {
        String[] parts = fullClassName.split("\\.");
        if (parts.length > 0) {
            return parts[parts.length - 1].trim();
        }
        return "";
    }

}
