package pl.org.opi.sdsm.app.vuespringsection.stru.generatePhase;

import pl.org.opi.sdsm.app.vuespringsection.stru.generatePhase.ui.GeneratePhasePanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

public class GeneratePhase implements Phase {

    private GeneratePhasePanel viewPanel;

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
            viewPanel = new GeneratePhasePanel();
        }
        return viewPanel;
    }
}
