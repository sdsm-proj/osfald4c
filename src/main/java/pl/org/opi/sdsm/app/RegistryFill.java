package pl.org.opi.sdsm.app;

import pl.org.opi.sdsm.app.frontenddto.FrontendDtoGenDef;
import pl.org.opi.sdsm.app.jsde01.Jsde01GenDef;
import pl.org.opi.sdsm.app.simplerepo.SimpleRepoGenDef;
import pl.org.opi.sdsm.app.spasection.SpaSectionGenDef;
import pl.org.opi.sdsm.app.vuespringsection.VueSpringSectionGenDef;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.GenDef;

import java.util.LinkedHashMap;

public class RegistryFill {
    public static void fill(LinkedHashMap<String, GenDef> definitionMap) {
        definitionMap.put(SimpleRepoGenDef.CODE, new SimpleRepoGenDef());
        definitionMap.put(VueSpringSectionGenDef.CODE, new VueSpringSectionGenDef());
        definitionMap.put(SpaSectionGenDef.CODE, new SpaSectionGenDef());
        definitionMap.put(FrontendDtoGenDef.CODE, new FrontendDtoGenDef());
        definitionMap.put(Jsde01GenDef.CODE, new Jsde01GenDef());
    }
}
