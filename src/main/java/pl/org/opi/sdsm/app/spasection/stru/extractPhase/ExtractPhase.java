package pl.org.opi.sdsm.app.spasection.stru.extractPhase;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

@Slf4j
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
        log.info("ExtractPhase.afterCreate");
    }

    @Override
    public void afterShow() {
        log.info("ExtractPhase.afterShow");
        viewPanel.afterShow();
    }

    @Override
    public JPanel getViewPanel() {
        if (viewPanel == null) {
            viewPanel = new ExtractViewPanel();
        }
        return viewPanel;
    }
}
