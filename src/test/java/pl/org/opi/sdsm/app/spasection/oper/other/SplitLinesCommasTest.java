package pl.org.opi.sdsm.app.spasection.oper.other;

import org.junit.jupiter.api.Test;

public class SplitLinesCommasTest {

    @Test
    public void test01() {
        String s = "";
        s += "aa,aa,fgdfgdfg,nv;a\nb,b;b,b,,,;;;;\ncccc";
        new SplitLinesCommas().exec(s);
    }

}
