package pl.org.opi.sdsm.frmwk.mechanics;

import lombok.Getter;
import lombok.Setter;
import pl.org.opi.sdsm.frmwk.mechanics.gen.Gen;
import pl.org.opi.sdsm.frmwk.mechanics.registry.PrjTypeRegistry;

public class SdsmCtx {
    
    //--------------------------------------------------------------------------

    private static SdsmCtx instance;
    
    public static synchronized SdsmCtx getInstance() {
        if (instance == null) {
            instance = new SdsmCtx();
        }
        return instance;
    }
    
    //--------------------------------------------------------------------------

    @Getter
    @Setter
    private Gen currGen = null;

    public PrjTypeRegistry getPrjTypeRegistry() {
        return PrjTypeRegistry.getInstance();
    }
    
    
    
    
}
