package pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase.ui.ZaExtractViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

@Slf4j
public class ZaExtractPhase implements Phase {

    private ZaExtractViewPanel viewPanel;

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
            viewPanel = new ZaExtractViewPanel();
        }
        return viewPanel;
    }
}
