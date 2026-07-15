package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.op;

import com.google.common.base.CaseFormat;

public class DefaultNames {
    
    public static String defaultRepositoryClassName(String tableName) {
        String s = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
        s = "Repo" + s;
        return s;
    }
    
    public static String defaultEntityClassName(String tableName) {
        String s = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
        s = "En" + s;
        return s;
    }

    public static String defaultTestClassName(String tableName) {
        String s = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
        s = "TestRepo" + s;
        return s;
    }
    
}
