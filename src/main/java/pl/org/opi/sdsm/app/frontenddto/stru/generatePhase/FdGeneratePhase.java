package pl.org.opi.sdsm.app.frontenddto.stru.generatePhase;

import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.app.frontenddto.model.var.GeneratePhaseVariablesModel;
import pl.org.opi.sdsm.app.frontenddto.stru.generatePhase.ui.FdGenerateViewPanel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;

public class FdGeneratePhase implements Phase {

    private FdGenerateViewPanel viewPanel;

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
        _FrontendDtoGenUtil.getModel().setGenVars(new GeneratePhaseVariablesModel());
    }

    @Override
    public void afterShow() {
    }

    @Override
    public JPanel getViewPanel() {
        if (viewPanel == null) {
            viewPanel = new FdGenerateViewPanel();
        }
        return viewPanel;
    }

}
