package pl.org.opi.sdsm.app.vuespringsection.stru.configPhase;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.vuespringsection.stru.configPhase.ui.ConfigViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

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
        log.info("ConfigPhase.afterCreate");
    }

    @Override
    public void afterShow() {
        log.info("ConfigPhase.afterShow");
    }

    @Override
    public JPanel getViewPanel() {
        if (viewPanel == null) {
            viewPanel = new ConfigViewPanel();
        }
        return viewPanel;
    }

}
