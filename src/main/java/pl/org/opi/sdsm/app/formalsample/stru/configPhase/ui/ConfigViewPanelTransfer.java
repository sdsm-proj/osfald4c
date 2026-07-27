package pl.org.opi.sdsm.app.formalsample.stru.configPhase.ui;

import pl.org.opi.sdsm.app.formalsample.model.FormalSampleGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

public class ConfigViewPanelTransfer {

    public ConfigViewPanelTransfer(ConfigViewPanel configViewPanel) {
        this.panel = configViewPanel;
    }

    private final ConfigViewPanel panel;

    public void ui2Model() {
        FormalSampleGenModel model = (FormalSampleGenModel) SdsmCtx.getInstance().getCurrGen().getModel();
        model.getConfigModel().setNazwaPlikuSql(panel.getEdNazwaPlikuSql().getText().trim());
    }

    public void model2Ui() {
        FormalSampleGenModel model = (FormalSampleGenModel) SdsmCtx.getInstance().getCurrGen().getModel();
        panel.getEdNazwaPlikuSql().setText(model.getConfigModel().getNazwaPlikuSql());
    }

}
