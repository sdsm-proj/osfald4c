package pl.org.opi.sdsm.app.simplerepo.stru.generatePhase;

import javax.swing.JPanel;
import pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

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
