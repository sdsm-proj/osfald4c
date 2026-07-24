package pl.org.opi.sdsm.frmwk.mechanics.gendef;

import pl.org.opi.sdsm.frmwk.mechanics.gen.Gen;

public interface GenDef {
    String getPrjCode();
    String getPrjRootShortFileName();
    Gen createInstance();
    Gen openInstance(String fullFileName);
}
