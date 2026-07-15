package pl.org.opi.sdsm.app.zestawienie_a.stru.configPhase;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.zestawienie_a.oper.configPhase.LoadOper;
import pl.org.opi.sdsm.app.zestawienie_a.stru.configPhase.ui.ZaConfigViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

@Slf4j
public class ZaConfigPhase implements Phase {

    private ZaConfigViewPanel viewPanel;

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
        new LoadOper(viewPanel).exec();
    }

    @Override
    public JPanel getViewPanel() {
        if (viewPanel == null) {
            viewPanel = new ZaConfigViewPanel();
        }
        return viewPanel;
    }
}
