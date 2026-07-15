package pl.org.opi.sdsm.app.jsde01.stru.generatePhase;

import pl.org.opi.sdsm.app.jsde01.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

public class GeneratePhase implements Phase {

    private GenerateViewPanel viewPanel;

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
            viewPanel = new GenerateViewPanel();
        }
        return viewPanel;
    }
}
