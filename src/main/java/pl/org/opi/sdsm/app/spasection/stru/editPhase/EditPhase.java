package pl.org.opi.sdsm.app.spasection.stru.editPhase;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.spasection.oper.editPhase.InitOper;
import pl.org.opi.sdsm.app.spasection.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

@Slf4j
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
        log.info("EditPhase.afterCreate");
        new InitOper(viewPanel).exec();
    }

    @Override
    public void afterShow() {
        log.info("EditPhase.afterShow");
    }

    @Override
    public JPanel getViewPanel() {
        if (viewPanel == null) {
            viewPanel = new EditViewPanel();
        }
        return viewPanel;
    }

}
