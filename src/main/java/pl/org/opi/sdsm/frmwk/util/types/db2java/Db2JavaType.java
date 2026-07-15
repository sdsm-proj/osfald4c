package pl.org.opi.sdsm.frmwk.util.types.db2java;

import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

public class Db2JavaType {

    public static String exec(String dbType, boolean notNull) {
        String t = dbType.toLowerCase();
        switch (t) {
            case "varchar":
                return "String";
            case "text":
                return "String";
            case "bool":
                if (notNull) {
                    return "boolean";
                } else {
                    return "Boolean";
                }
            case "int4":
                if (notNull) {
                    return "int";
                } else {
                    return "Integer";
                }
            case "int8":
                if (notNull) {
                    return "long";
                } else {
                    return "Long";
                }
            case "bigserial":
                if (notNull) {
                    return "long";
                } else {
                    return "Long";
                }
            case "float8":
                if (notNull) {
                    return "double";
                } else {
                    return "Double";
                }
            case "numeric":
                return "BigDecimal";
            case "date":
                return "LocalDate";
            case "time":
                return "LocalTime";
            case "timestamp":
                return "LocalDateTime";
            case "timestamptz":
                return "LocalDateTime";
            default:
                throw new OsfaldRuntimeException("Unknown db type: " + t);
        }
    }
}
