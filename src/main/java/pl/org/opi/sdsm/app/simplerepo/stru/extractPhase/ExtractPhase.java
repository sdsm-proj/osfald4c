package pl.org.opi.sdsm.app.simplerepo.stru.extractPhase;

import javax.swing.JPanel;

import pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public class ExtractPhase implements Phase {

    private ExtractViewPanel viewPanel;

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
            viewPanel = new ExtractViewPanel();
        }
        return viewPanel;
    }
    
}
