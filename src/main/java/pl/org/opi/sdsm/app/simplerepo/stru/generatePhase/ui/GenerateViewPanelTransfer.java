package pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui;

import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo.model.SimpleRepoGenModel;
import pl.org.opi.sdsm.app.simplerepo.model.queries.sub.QueryDetails;
import pl.org.opi.sdsm.app.simplerepo.model.tables.sub.TableDetails;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;

public class GenerateViewPanelTransfer {

    public GenerateViewPanelTransfer(GenerateViewPanel panel) {
        this.panel = panel;
    }

    private final GenerateViewPanel panel;

    public void ui2Model() {
        TableDetails td = getModel();
        if (td != null) {
            td.getGenerateParams().setRepositoryClassName(panel.getEdRepositoryClassName().getText().trim());
            td.getGenerateParams().setRepositoryRelativePath(panel.getEdRepositoryPathRel().getText().trim());
            td.getGenerateParams().setEntityClassName(panel.getEdEntityClassName().getText().trim());
            td.getGenerateParams().setEntityRelativePath(panel.getEdEntityPathRel().getText().trim());
            td.getGenerateParams().setTestClassName(panel.getEdTestClassName().getText().trim());
            td.getGenerateParams().setTestRelativePath(panel.getEdTestPathRel().getText().trim());
        }

        QueryDetails qd = getModelQuery();
        if (qd != null) {
            qd.getGenerateParamsQuery().setQueryClassName(panel.getEdQueryClassName().getText().trim());
            qd.getGenerateParamsQuery().setQueryEntityClassName(panel.getEdQueryEntityName().getText().trim());
            qd.getGenerateParamsQuery().setQueryRelativePath(panel.getEdQueryPathRel().getText().trim());
            qd.getGenerateParamsQuery().setTestClassName(panel.getEdQryTestClassName().getText().trim());
            qd.getGenerateParamsQuery().setTestRelativePath(panel.getEdQryTestPathRel().getText().trim());
        }
    }

    public void model2Ui() {
        TableDetails td = getModel();
        if (td != null) {
            panel.getEdRepositoryClassName().setText(td.getGenerateParams().getRepositoryClassName());
            panel.getEdRepositoryPathRel().setText(td.getGenerateParams().getRepositoryRelativePath());
            panel.getEdEntityClassName().setText(td.getGenerateParams().getEntityClassName());
            panel.getEdEntityPathRel().setText(td.getGenerateParams().getEntityRelativePath());
            panel.getEdTestClassName().setText(td.getGenerateParams().getTestClassName());
            panel.getEdTestPathRel().setText(td.getGenerateParams().getTestRelativePath());
        }

        QueryDetails qd = getModelQuery();
        if (qd != null) {
            panel.getEdQueryClassName().setText(qd.getGenerateParamsQuery().getQueryClassName());
            panel.getEdQueryEntityName().setText(qd.getGenerateParamsQuery().getQueryEntityClassName());
            panel.getEdQueryPathRel().setText(qd.getGenerateParamsQuery().getQueryRelativePath());
            panel.getEdQryTestClassName().setText(qd.getGenerateParamsQuery().getTestClassName());
            panel.getEdQryTestPathRel().setText(qd.getGenerateParamsQuery().getTestRelativePath());
        }
    }

    private TableDetails getModel() {
        String tableName = panel.getListChosenTables().getSelectedValue();
        if (StringUtils.isBlank(tableName)) {
            return null;
        }
        SimpleRepoGenModel model = (SimpleRepoGenModel) SdsmCtx.getInstance().getCurrGen().getModel();
        TableDetails td = model.getTablesModel().getMapTables().get(tableName);
        if (td == null) {
            throw new OsfaldRuntimeException("Model of table: " + tableName + " not found");
        }
        return td;
    }

    private QueryDetails getModelQuery() {
        String queryName = panel.getListChosenQueries().getSelectedValue();
        if (StringUtils.isBlank(queryName)) {
            return null;
        }
        SimpleRepoGenModel model = (SimpleRepoGenModel) SdsmCtx.getInstance().getCurrGen().getModel();
        QueryDetails qd = model.getQueriesModel().getMapQueries().get(queryName);
        if (qd == null) {
            throw new OsfaldRuntimeException("Model of query: " + queryName + " not found");
        }
        return qd;
    }

}
