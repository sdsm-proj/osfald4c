package pl.org.opi.sdsm.app.frontenddto.stru.extractPhase;

import pl.org.opi.sdsm.app.frontenddto.stru.extractPhase.ui.FdExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

public class FdExtractPhase implements Phase {

    private FdExtractViewPanel viewPanel;

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
            viewPanel = new FdExtractViewPanel();
        }
        return viewPanel;
    }

}
