package pl.org.opi.sdsm.app.jsde01.stru.editPhase;

import pl.org.opi.sdsm.app.jsde01.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

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
