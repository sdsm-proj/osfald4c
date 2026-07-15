package pl.org.opi.sdsm.app.spasection.stru.generatePhase;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.InitOper;
import pl.org.opi.sdsm.app.spasection.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

@Slf4j
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
        log.info("GeneratePhase.afterCreate");
    }

    @Override
    public void afterShow() {
        log.info("GeneratePhase.afterShow");
        new InitOper(viewPanel).exec();
    }

    @Override
    public JPanel getViewPanel() {
        if (viewPanel == null) {
            viewPanel = new GenerateViewPanel();
        }
        return viewPanel;
    }
}
