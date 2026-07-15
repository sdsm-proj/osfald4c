package pl.org.opi.sdsm.app.simplerepo.stru.configPhase.ui;

import pl.org.opi.sdsm.app.simplerepo.model.SimpleRepoGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

public class ConfigViewPanelTransfer {

    public ConfigViewPanelTransfer(ConfigViewPanel configViewPanel) {
        this.panel = configViewPanel;
    }
    
    private final ConfigViewPanel panel;
    
    public void ui2Model() {
        SimpleRepoGenModel model = (SimpleRepoGenModel) SdsmCtx.getInstance().getCurrGen().getModel();
        model.getConfigModel().setDatabaseUrl(panel.getEdDatabaseUrl().getText().trim());
        model.getConfigModel().setDatabaseUser(panel.getEdDatabaseUser().getText().trim());
        model.getConfigModel().setDatabasePass(panel.getEdDatabasePass().getText().trim());
    }
    
    public void model2Ui() {
        SimpleRepoGenModel model = (SimpleRepoGenModel) SdsmCtx.getInstance().getCurrGen().getModel();
        panel.getEdDatabaseUrl().setText(model.getConfigModel().getDatabaseUrl());
        panel.getEdDatabaseUser().setText(model.getConfigModel().getDatabaseUser());
        panel.getEdDatabasePass().setText(model.getConfigModel().getDatabasePass());
    }

}
