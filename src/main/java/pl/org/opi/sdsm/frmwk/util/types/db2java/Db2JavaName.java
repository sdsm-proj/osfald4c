package pl.org.opi.sdsm.frmwk.util.types.db2java;

import com.google.common.base.CaseFormat;

public class Db2JavaName {

    public static String exec(String dbName) {
        String s = dbName.toLowerCase();
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, s);
    }

}
