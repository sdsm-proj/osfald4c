package pl.org.opi.sdsm.app.simplerepo.oper.editPhase.other;

import java.util.LinkedHashMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.frmwk.util.types.db2java.Db2JavaName;
import pl.org.opi.sdsm.frmwk.util.types.db2java.Db2JavaType;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class SetDefaultJavaNamesOp {

    public SetDefaultJavaNamesOp(LinkedHashMap<String, FldDetails> mapFlds, boolean overwrite) {
        this.mapFlds = mapFlds;
        this.overwrite = overwrite;
    }

    private final LinkedHashMap<String, FldDetails> mapFlds;
    
    private final boolean overwrite;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() {
        for (FldDetails fld : mapFlds.values()) {
            fld.setJavaNameDefault(Db2JavaName.exec(fld.getFldName()));
            if (StringUtils.isBlank(fld.getJavaNameFinal()) || overwrite) {
                fld.setJavaNameFinal(Db2JavaName.exec(fld.getFldName()));
            }
            fld.setJavaTypeDefault(Db2JavaType.exec(fld.getDbTypeStr(), fld.isNotNull()));
            if (StringUtils.isBlank(fld.getJavaTypeFinal()) || overwrite) {
                fld.setJavaTypeFinal(Db2JavaType.exec(fld.getDbTypeStr(), fld.isNotNull()));
            }
        }
    }

}
