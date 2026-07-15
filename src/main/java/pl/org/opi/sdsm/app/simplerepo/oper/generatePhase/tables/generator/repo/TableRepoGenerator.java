package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.generator.repo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.commons.str.Q;
import pl.org.opi.commons.str.Strings2Lines;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.TableDetails;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.util.filePathPckg.FilePathPckg;
import pl.org.opi.sdsm.frmwk.util.fileSave.FileSave;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.types.java2stmt.StmtSetGetMapper;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

@Slf4j
public class TableRepoGenerator {

    public TableRepoGenerator(String tableName) {
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
        if (StringUtils.isBlank(tableDetails.getGenerateParams().getRepositoryClassName())) {
            throw new OsfaldRuntimeException("Repository class name cannot be empty.");
        }
        if (StringUtils.isBlank(tableDetails.getGenerateParams().getRepositoryRelativePath())) {
            throw new OsfaldRuntimeException("Repository rel. path cannot be empty.");
        }
    }

    private void prepareDetails() {
        // repositoryPackage
        String relPath = tableDetails.getGenerateParams().getRepositoryRelativePath();
        tableDetails.getGenerateDetails().setRepositoryPackage(FilePathPckg.relativePath2Package(relPath));
    }

    private void createContent() {
        Map<String, Object> params = new HashMap<>();
        
        params.put("_repo_package_name_", tableDetails.getGenerateDetails().getRepositoryPackage());
        params.put("_repo_class_name_", tableDetails.getGenerateParams().getRepositoryClassName());
        params.put("_entity_package_name_", tableDetails.getGenerateDetails().getEntityPackage());
        params.put("_entity_class_name_", tableDetails.getGenerateParams().getEntityClassName());
        params.put("_primary_key_getter_", tableDetails.getPrimaryKey().getGetterName());

        params.put("_insert_sql_", insertSql());
        params.put("_update_sql_", updateSql());
        params.put("_find_all_sql_", findAllSql());
        params.put("_find_by_key_sql_", findByKeySql());
        params.put("_find_by_autoinc_sql_", findByAutoincSql());
        
        params.put("_entity2Stmt_", entity2Stmt(params));
        params.put("_rs2Entity_", rs2Entity());
        
        VelTempl t = new VelTempl("app/simplerepo/TableRepoGenerator.vm", params);
        content = t.build();
    }

    private void save() throws IOException {
        FileSave.save(
                tableDetails.getGenerateParams().getRepositoryRelativePath(),
                tableDetails.getGenerateParams().getRepositoryClassName() + ".java",
                content, true);
    }

    //--------------------------------------------------------------------------
    
    private String insertSql() {
        String margin = "        ";
        String s = "";
        s += margin + margin + Q.d(" insert into " + tableDetails.getTableSchem() + "." + tableDetails.getTableName() + " ( ") + " +\n";
        List<String> fldNames = new ArrayList<>();
        List<String> fldQMarks = new ArrayList<>();
        for (FldDetails fld : tableDetails.getMapFlds().values()) {
            if (!fld.isAutoIncrement()) {
                fldNames.add(fld.getFldName());
                fldQMarks.add("?");
            }
        }
        
        List<String> rsltFldLines = new Strings2Lines(fldNames, ",", 60).exec();
        for(String fldsLine: rsltFldLines) {
            s += margin + margin + margin + "\" " + fldsLine + " \"" + " +\n";
        }
        s += margin + margin + margin + Q.d(" ) values ( ") + " +\n";

        List<String> rsltQLines = new Strings2Lines(fldQMarks, ",", 60).exec();
        for(String qLine: rsltQLines) {
            s += margin + margin + margin + "\" " + qLine + " \"" + " +\n";
        }
        
        s += margin + margin + margin  + Q.d(" )");
        
        return s;
    }

    private String updateSql() {
        String margin = "        ";
        String s = "";
        s += margin + margin + Q.d(" update " + tableDetails.getTableSchem() + "." + tableDetails.getTableName() + " set ") + " +\n";
        List<String> fldNames = new ArrayList<>();
        for (FldDetails fld : tableDetails.getMapFlds().values()) {
            if (fld.isAutoIncrement() || fld.isPrimaryKey()) {
                continue;
            }
            fldNames.add(fld.getFldName() + " = ?");
        }
        
        List<String> rsltFldLines = new Strings2Lines(fldNames, ",", 60).exec();
        for(String fldsLine: rsltFldLines) {
            s += margin + margin + margin + "\" " + fldsLine + " \"" + " +\n";
        }
        
        s += margin + margin + margin + Q.d(" where " + tableDetails.getPrimaryKey().getFldName() + " = ? ");
        
        return s;
    }
    
    private String findAllSql() {
        String s = "";
        s += "select * from " + tableDetails.getTableSchem() + "." + tableDetails.getTableName();
        s += " order by " + tableDetails.getAutoIncrement().getFldName(); 
        return s;
    }
    
    private String findByKeySql() {
        String s = "";
        s += "select * from " + tableDetails.getTableSchem() + "." + tableDetails.getTableName();
        s += " where " + tableDetails.getPrimaryKey().getFldName() + " = ?"; 
        return s;
    }
    
    private String findByAutoincSql() {
        String s = "";
        s += "select * from " + tableDetails.getTableSchem() + "." + tableDetails.getTableName();
        s += " where " + tableDetails.getAutoIncrement().getFldName() + " = ?"; 
        return s;
    }
    
    private String entity2Stmt(Map<String, Object> params) {
        String margin = "        ";
        String s = "";
        int cnt = 0;
        
        for (FldDetails fld : tableDetails.getMapFlds().values()) {
            if (fld.isAutoIncrement() || fld.isPrimaryKey()) {
                continue;
            }
            cnt++;
            String line = "";
            line += "StmtSet.set";
            line += StmtSetGetMapper.stmtMethodType(fld.getJavaTypeFinal(), fld.isNotNull());
            line += "(stmt, offset + ";
            line += (cnt + 1);
            line += ", ";
            line += "en." + fld.getGetterName() + "());";
            line += "\n";
            s += margin + line;
        }
        
        s = StringUtils.removeEnd(s, "\n");
        params.put("_last_update_index_", (cnt+2));
        return s;
    }
    
    private String rs2Entity() {
        String margin = "        ";
        String s = "";
        for (FldDetails fld : tableDetails.getMapFlds().values()) {
            String line = "";
            line += "en.";
            line += fld.getSetterName();
            line += "(StmtGet.get";
            line += StmtSetGetMapper.stmtMethodType(fld.getJavaTypeFinal(), fld.isNotNull());
            line += "(rs, " + Q.d(fld.getFldName());
            line += "));";
            line += "\n";
            s += margin + line;
        }
        s = StringUtils.removeEnd(s, "\n");
        return s;
    }

}
