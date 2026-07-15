package pl.org.opi.sdsm.app.simplerepo.stru.editPhase;

import javax.swing.JPanel;
import pl.org.opi.sdsm.app.simplerepo.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

public class EditPhase implements Phase {
    
    private EditViewPanel viewPanel;

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
            viewPanel = new EditViewPanel();
        }
        return viewPanel;
    }
    
}
