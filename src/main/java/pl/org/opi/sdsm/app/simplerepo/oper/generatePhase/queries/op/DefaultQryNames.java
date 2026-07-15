package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.op;

import com.google.common.base.CaseFormat;

public class DefaultQryNames {

    public static String defaultQryClassName(String qryName) {
        String s = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, qryName);
        s = "Qry" + s;
        return s;
    }

    public static String defaultQryEntityName(String qryName) {
        String s = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, qryName);
        s = "Qen"; // + s;
        return s;
    }

    public static String defaultQryTestClassName(String qryName) {
        String s = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, qryName);
        s = "TestQry" + s;
        return s;
    }
    
}
