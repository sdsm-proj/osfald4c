package pl.org.opi.sdsm.frmwk.util.types.java2stmt;

import pl.org.opi.commons.str.Q;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

public class DefaultValueForJavaType {
    
    public static String getDefaultValue(String javaType, boolean firstSecond) {
        switch(javaType) {
            case "String":
                if (firstSecond) {
                    return Q.d("a");
                } else {
                    return Q.d("b");
                }
            case "boolean":
                if (firstSecond) {
                    return "true";
                } else {
                    return "false";
                }
            case "Boolean":
                if (firstSecond) {
                    return "true";
                } else {
                    return "false";
                }
            case "int":
                if (firstSecond) {
                    return "1";
                } else {
                    return "2";
                }
            case "Integer":
                if (firstSecond) {
                    return "1";
                } else {
                    return "2";
                }
            case "long":
                if (firstSecond) {
                    return "1L";
                } else {
                    return "2L";
                }
            case "Long":
                if (firstSecond) {
                    return "1L";
                } else {
                    return "2L";
                }
            case "double":
                if (firstSecond) {
                    return "1.1";
                } else {
                    return "2.2";
                }
            case "Double":
                if (firstSecond) {
                    return "1.1";
                } else {
                    return "2.2";
                }
            case "BigDecimal":
                if (firstSecond) {
                    return "new BigDecimal(\"100.1\")";
                } else {
                    return "new BigDecimal(\"200.2\")";
                }
            case "LocalDate":
                return "LocalDate.now()";
            case "LocalTime":
                return "LocalTime.now()";
            case "LocalDateTime":
                return "LocalDateTime.now()";
        }
        throw new OsfaldRuntimeException("Not found stmtMethodType for: " + javaType + ", firstSecond: " + firstSecond);
    }
    
}
