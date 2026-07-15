package pl.org.opi.sdsm.frmwk.util.types.java2stmt;

import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

public class StmtSetGetMapper {

    public static String stmtMethodType(String javaTypeFinal, boolean notNull) {
        switch(javaTypeFinal) {
            case "String":
                return "String";
            case "boolean":
                return "Boolean";
            case "Boolean":
                return "BooleanNull";
            case "int":
                return "Int";
            case "Integer":
                return "IntNull";
            case "long":
                return "Long";
            case "Long":
                return "LongNull";
            case "double":
                return "Double";
            case "Double":
                return "DoubleNull";
            case "BigDecimal":
                return "BigDecimal";
            case "LocalDate":
                return "LocalDate";
            case "LocalTime":
                return "LocalTime";
            case "LocalDateTime":
                return "LocalDateTime";
        }
        throw new OsfaldRuntimeException("Not found stmtMethodType for: " + javaTypeFinal + ", notNull: " + notNull);
    } 
    
}
