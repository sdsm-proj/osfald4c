package pl.org.opi.sdsm.frmwk.mechanics.registry;

import pl.org.opi.sdsm.app.RegistryFill;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.GenDef;

import java.util.Collection;
import java.util.LinkedHashMap;

public class PrjTypeRegistry {
    
    //--------------------------------------------------------------------------

    private static PrjTypeRegistry instance;
    
    public static PrjTypeRegistry getInstance() {
        if (instance == null) {
            instance = new PrjTypeRegistry();
            RegistryFill.fill(instance.definitionMap);
        }
        return instance;
    }
    
    //--------------------------------------------------------------------------
    
    private final LinkedHashMap<String, GenDef> definitionMap = new LinkedHashMap<>();

    public GenDef getDefinitionByCode(String code) {
        return definitionMap.get(code);
    }  
    
    public Collection<GenDef> getDefinitionList() {
        return definitionMap.values();
    }
    
}
