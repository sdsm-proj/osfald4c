package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.generator.test;

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
import pl.org.opi.sdsm.frmwk.util.types.java2stmt.DefaultValueForJavaType;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

@Slf4j
public class TableRepoTestGenerator {
    
    public TableRepoTestGenerator(String tableName) {
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
        if (skip()) return;
        checkParams();
        prepareDetails();
        createContent();
        SdsmCtx.getInstance().getCurrGen().save();
        save();
    }

    private boolean skip() {
        tableDetails = _SimpleRepoGenUtil.getModel().getTablesModel().getMapTables().get(tableName);
        return StringUtils.isBlank(tableDetails.getGenerateParams().getTestClassName());
    }

    private void checkParams() {
        tableDetails = _SimpleRepoGenUtil.getModel().getTablesModel().getMapTables().get(tableName);
        if (tableDetails == null) {
            throw new OsfaldRuntimeException("Definition of table: " + tableName + " not found.");
        }
        if (StringUtils.isBlank(tableDetails.getGenerateParams().getTestClassName())) {
            throw new OsfaldRuntimeException("Test class name cannot be empty.");
        }
        if (StringUtils.isBlank(tableDetails.getGenerateParams().getTestRelativePath())) {
            throw new OsfaldRuntimeException("Test rel. path cannot be empty.");
        }
    }
    
    private void prepareDetails() {
        // testPackage
        String relPath = tableDetails.getGenerateParams().getTestRelativePath();
        tableDetails.getGenerateDetails().setTestPackage(FilePathPckg.relativePath2Package(relPath));
    }
    
    private void createContent() {
        Map<String, Object> params = new HashMap<>();
        
        params.put("_test_package_name_", tableDetails.getGenerateDetails().getTestPackage());
        params.put("_test_class_name_", tableDetails.getGenerateParams().getTestClassName());
        
        params.put("_entity_package_name_", tableDetails.getGenerateDetails().getEntityPackage());
        params.put("_entity_class_name_", tableDetails.getGenerateParams().getEntityClassName());
        params.put("_repo_package_name_", tableDetails.getGenerateDetails().getRepositoryPackage());
        params.put("_repo_class_name_", tableDetails.getGenerateParams().getRepositoryClassName());

        
        params.put("_primary_key_setter_", tableDetails.getPrimaryKey().getSetterName());
        params.put("_autoinc_key_getter_", tableDetails.getAutoIncrement().getGetterName());
        params.put("_set_not_null_fields_for_create_", setNotNullFieldsForCreate());
        params.put("_set_all_fields_for_update_", setAllFieldsForUpdate());
        
        VelTempl t = new VelTempl("app/simplerepo/TableRepoTestGenerator.vm", params);
        content = t.build();
    }
    
    private void save() throws IOException {
        FileSave.save(
                tableDetails.getGenerateParams().getTestRelativePath(),
                tableDetails.getGenerateParams().getTestClassName() + ".java",
                content, true);
    }
    
    //--------------------------------------------------------------------------
    
    private String setNotNullFieldsForCreate() {
        String margin = "            ";
        String s = "";
        for (FldDetails fld : tableDetails.getMapFlds().values()) {
            if (fld.isPrimaryKey()) continue;
            if (fld.isAutoIncrement()) continue;
            if (!fld.isNotNull()) continue;

            String line = "";
            line += "en1.";
            line += fld.getSetterName();
            line += "(";
            line += DefaultValueForJavaType.getDefaultValue(fld.getJavaTypeFinal(), true);
            line += ");";
            line += "\n";
            s += margin + line;
        }
        s = StringUtils.removeEnd(s, "\n");
        return s;
    }

    private String setAllFieldsForUpdate() {
        String margin = "            ";
        String s = "";
        for (FldDetails fld : tableDetails.getMapFlds().values()) {
            if (fld.isPrimaryKey()) continue;
            if (fld.isAutoIncrement()) continue;

            String line = "";
            line += "en2.";
            line += fld.getSetterName();
            line += "(";
            line += DefaultValueForJavaType.getDefaultValue(fld.getJavaTypeFinal(), false);
            line += ");";
            line += "\n";
            s += margin + line;
        }
        s = StringUtils.removeEnd(s, "\n");
        return s;
    }
    
}
