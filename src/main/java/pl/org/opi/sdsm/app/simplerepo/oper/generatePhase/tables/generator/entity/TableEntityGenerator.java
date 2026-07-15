package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.generator.entity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.TableDetails;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.util.filePathPckg.FilePathPckg;
import pl.org.opi.sdsm.frmwk.util.fileSave.FileSave;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

@Slf4j
public class TableEntityGenerator {
    
    public TableEntityGenerator(String tableName) {
        this.tableName = tableName;
    }

    private final String tableName;

    private TableDetails tableDetails;

    private String content = "";
    
    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() throws IOException {
        checkParams();
        prepareDetails();
        createContent();
        SdsmCtx.getInstance().getCurrGen().save();
        save();
    }
    
    private void checkParams() {
        tableDetails = _SimpleRepoGenUtil.getModel().getTablesModel().getMapTables().get(tableName);
        if (tableDetails == null) {
            throw new OsfaldRuntimeException("Definition of table: " + tableName + " not found.");
        }
        if (StringUtils.isBlank(tableDetails.getGenerateParams().getEntityClassName())) {
            throw new OsfaldRuntimeException("Entity class name cannot be empty.");
        }
        if (StringUtils.isBlank(tableDetails.getGenerateParams().getEntityRelativePath())) {
            throw new OsfaldRuntimeException("Entity rel. path cannot be empty.");
        }
    }
    
    private void prepareDetails() {
        // entityPackage
        String relPath = tableDetails.getGenerateParams().getEntityRelativePath();
        tableDetails.getGenerateDetails().setEntityPackage(FilePathPckg.relativePath2Package(relPath));
    }

    private void createContent() {
        Map<String, Object> params = new HashMap<>();
        params.put("_entity_package_name_", tableDetails.getGenerateDetails().getEntityPackage());
        params.put("_entity_class_name_", tableDetails.getGenerateParams().getEntityClassName());
        
        params.put("_fields_", fields());
        VelTempl t = new VelTempl("app/simplerepo/TableEntityGenerator.vm", params);
        content = t.build();
    }
    
    private void save() throws IOException {
        FileSave.save(
                tableDetails.getGenerateParams().getEntityRelativePath(),
                tableDetails.getGenerateParams().getEntityClassName() + ".java", 
                content, true);
    }

    //--------------------------------------------------------------------------
    
    private String fields() {
        String s = "";
        for(FldDetails fld: tableDetails.getMapFlds().values()) {
            s += "    " + "private " + fld.getJavaTypeFinal() + " " + fld.getJavaNameFinal() + ";\n";
        }
        return s;
    }
    
}
