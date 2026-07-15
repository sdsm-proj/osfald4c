package pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.generator.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo._SimpleRepoGenUtil;
import pl.org.opi.sdsm.app.simplerepo.model.queries.sub.QueryDetails;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.util.filePathPckg.FilePathPckg;
import pl.org.opi.sdsm.frmwk.util.fileSave.FileSave;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

@Slf4j
public class QryTestGenerator {

    public QryTestGenerator(String queryName) {
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
        if (StringUtils.isBlank(queryDetails.getGenerateParamsQuery().getTestClassName())) {
            throw new OsfaldRuntimeException("Query test class name cannot be empty.");
        }
        if (StringUtils.isBlank(queryDetails.getGenerateParamsQuery().getTestRelativePath())) {
            throw new OsfaldRuntimeException("Query rel. test path cannot be empty.");
        }
    }
    
    private void prepareDetails() {
        // queryTestPackage
        String relPath = queryDetails.getGenerateParamsQuery().getTestRelativePath();
        queryDetails.getGenerateDetailsQuery().setQueryTestPackage(FilePathPckg.relativePath2Package(relPath));
    }
    
    private void createContent() {
        Map<String, Object> params = new HashMap<>();
        
        params.put("_test_package_name_", queryDetails.getGenerateDetailsQuery().getQueryTestPackage());
        params.put("_test_class_name_", queryDetails.getGenerateParamsQuery().getTestClassName());
        params.put("_query_package_name_", queryDetails.getGenerateDetailsQuery().getQueryPackage());
        params.put("_query_class_name_", queryDetails.getGenerateParamsQuery().getQueryClassName());
        params.put("_query_class_name_", queryDetails.getGenerateParamsQuery().getQueryClassName());
        params.put("_query_entity_class_name_", queryDetails.getGenerateParamsQuery().getQueryEntityClassName());
        
        VelTempl t = new VelTempl("app/simplerepo/QryTestGenerator.vm", params);
        content = t.build();
    }
    
    private void save() throws IOException {
        FileSave.save(
                queryDetails.getGenerateParamsQuery().getTestRelativePath(),
                queryDetails.getGenerateParamsQuery().getTestClassName() + ".java",
                content, true);
    }
    
}
