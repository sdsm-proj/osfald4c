package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.generator.qry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.util.str.Q;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.queries.sub.QueryDetails;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.FldDetails;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.util.filePathPckg.FilePathPckg;
import pl.org.opi.sdsm.frmwk.util.fileSave.FileSave;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.types.java2stmt.StmtSetGetMapper;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

@Slf4j
public class QryGenerator {

    public QryGenerator(String queryName) {
        this.queryName = queryName;
    }

    private final String queryName;

    private QueryDetails queryDetails;

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
        queryDetails = _SimpleRepoGenUtil.getModel().getQueriesModel().getMapQueries().get(queryName);
        if (queryDetails == null) {
            throw new OsfaldRuntimeException("Definition of query: " + queryName + " not found.");
        }
        if (StringUtils.isBlank(queryDetails.getGenerateParamsQuery().getQueryClassName())) {
            throw new OsfaldRuntimeException("Query class name cannot be empty.");
        }
        if (StringUtils.isBlank(queryDetails.getGenerateParamsQuery().getQueryEntityClassName())) {
            throw new OsfaldRuntimeException("Query entity name cannot be empty.");
        }
        if (StringUtils.isBlank(queryDetails.getGenerateParamsQuery().getQueryRelativePath())) {
            throw new OsfaldRuntimeException("Query rel. path cannot be empty.");
        }
    }
    
    private void prepareDetails() {
        // repositoryPackage
        String relPath = queryDetails.getGenerateParamsQuery().getQueryRelativePath();
        queryDetails.getGenerateDetailsQuery().setQueryPackage(FilePathPckg.relativePath2Package(relPath));
    }
    
    private void createContent() {
        Map<String, Object> params = new HashMap<>();
        
        params.put("_query_package_name_", queryDetails.getGenerateDetailsQuery().getQueryPackage());
        params.put("_query_class_name_", queryDetails.getGenerateParamsQuery().getQueryClassName());
        params.put("_query_entity_class_name_", queryDetails.getGenerateParamsQuery().getQueryEntityClassName());
        params.put("_fields_", fields());
        params.put("_find_all_sql_", findAllSql());
        params.put("_rs2Entity_", rs2Entity());
        
        VelTempl t = new VelTempl("app/simplerepo/QryGenerator.vm", params);
        content = t.build();
    }
    
    private void save() throws IOException {
        FileSave.save(
                queryDetails.getGenerateParamsQuery().getQueryRelativePath(),
                queryDetails.getGenerateParamsQuery().getQueryClassName() + ".java",
                content, true);
    }

    //--------------------------------------------------------------------------
    
    private String fields() {
        String s = "";
        for(FldDetails fld: queryDetails.getMapFlds().values()) {
            s += "        " + "private " + fld.getJavaTypeFinal() + " " + fld.getJavaNameFinal() + ";\n";
        }
        return s;
    }
    
    private String findAllSql() {
        String s = "";
        String sql = queryDetails.getSql();
        String[] parts = sql.split("\n");
        for(String part : parts) {
            s += "        sql += \" " + part.trim() + " \";\n";
        }
        return s;        
    }
    
    private String rs2Entity() {
        String margin = "        ";
        String s = "";
        for (FldDetails fld : queryDetails.getMapFlds().values()) {
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
