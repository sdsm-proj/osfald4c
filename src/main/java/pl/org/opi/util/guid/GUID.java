package pl.org.opi.util.guid;

import java.util.UUID;

public class GUID {

    public static String gen() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String gen6() {
        return gen().substring(0, 6);
    }

}
