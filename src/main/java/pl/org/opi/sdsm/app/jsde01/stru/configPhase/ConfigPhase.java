package pl.org.opi.sdsm.app.jsde01.stru.configPhase;

import pl.org.opi.sdsm.app.jsde01.stru.configPhase.ui.ConfigViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

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
