package pl.org.opi.sdsm.app.formalsample.stru.configPhase;

import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.formalsample.stru.configPhase.ui.ConfigViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

@Slf4j
public class ConfigPhase implements Phase {
    private ConfigViewPanel viewPanel;

    @Override
    public boolean canShow() {
        return true;
    }
    @Override
    public boolean canClose() {
        return true;
    }
    @Override
    public void afterCreate() {
    }
    @Override
    public void afterShow() {
    }
    @Override
    public JPanel getViewPanel() {
        if (viewPanel == null) {
            viewPanel = new ConfigViewPanel();
        }
        return viewPanel;
    }
}
