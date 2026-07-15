package pl.org.opi.sdsm.frmwk.mechanics.gendef;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.mechanics.gen.BaseGen;
import pl.org.opi.sdsm.frmwk.mechanics.gen.Gen;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.GenModel;
import pl.org.opi.sdsm.frmwk.util.serde.Serde;

import java.lang.reflect.Field;

@Slf4j
@Getter
public abstract class BaseGenDef implements GenDef {

    public BaseGenDef(String prjCode, String prjDisplayName, Class<? extends BaseGen> prjClass, Class<? extends BaseGenModel> modelClass, String prjRootShortFileName) {
        this.prjCode = prjCode;
        this.prjDisplayName = prjDisplayName;
        this.prjClass = prjClass;
        this.modelClass = modelClass;
        this.prjRootShortFileName = prjRootShortFileName;
    }

    private final String prjCode;
    
    private final String prjDisplayName;
    
    private final Class<? extends BaseGen> prjClass;
    
    private final Class<? extends BaseGenModel> modelClass;
    
    private final String prjRootShortFileName;
    
    @Override
    public Gen createInstance() {
        return createInstanceCore(getPrjClass(), getModelClass());
    }

    @Override
    public Gen openInstance(String fullFileName) {
        return openInstanceCore(getPrjClass(), getModelClass(), fullFileName);
    }
    
    protected void _setModel(Gen gen, GenModel model) {
        try {
            //Field fieldModel = prj.getClass().getDeclaredField("model");
            Field fieldModel = gen.getClass().getSuperclass().getDeclaredField("model");
            fieldModel.setAccessible(true);
            fieldModel.set(gen, model);

            int dbg1 = 1;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new OsfaldRuntimeException(ex.getMessage(), ex);
        }
    }

    protected Gen createInstanceCore(Class<? extends BaseGen> prjClass, Class<? extends BaseGenModel> modelClass) {
        try {
            BaseGen prj = prjClass.getDeclaredConstructor().newInstance();
            BaseGenModel model = modelClass.getDeclaredConstructor().newInstance();
            _setModel(prj, model);
            model.setCode(getPrjCode());
            return prj;
        } catch (Exception ex) {
            throw new OsfaldRuntimeException(ex.getMessage(), ex);
        }
    }

    protected Gen openInstanceCore(Class<? extends BaseGen> prjClass, Class<? extends BaseGenModel> modelClass, String fullFileName) {
        try {
            BaseGen prj = prjClass.getDeclaredConstructor().newInstance();
            GenModel model = (GenModel) Serde.deser(fullFileName, modelClass);
            _setModel(prj, model);
            return prj;
        } catch (Exception ex) {
            throw new OsfaldRuntimeException(ex.getMessage(), ex);
        }
    }

    @Override
    public String toString() {
        return prjDisplayName;
    }
    
}
