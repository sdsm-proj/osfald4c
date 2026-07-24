package pl.org.opi.sdsm.frmwk.mechanics.gen;

import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;
import pl.org.opi.sdsm.frmwk.mechanics.uc.mainwindow.UcClearView;
import pl.org.opi.sdsm.frmwk.mechanics.uc.mainwindow.UcSetView;
import pl.org.opi.sdsm.frmwk.util.serde.Serde;

import java.awt.*;

public abstract class BaseGen implements Gen {

    private BaseGenModel model;

    private Phase currPhaseView;

    @Override
    public void save() {
        Serde.ser(model.getPrjFullFileName(), model);
    }

    @Override
    public BaseGenModel getModel() {
        return model;
    }

    @Override
    public boolean canCloseCurrPhase() {
        if (currPhaseView != null) {
            return currPhaseView.canClose();
        }
        return true;
    }

    @Override
    public boolean showPhase(EnumPhase phase) {
        currPhaseView = null;
        new UcClearView().exec();
        Phase pv = createPhaseView(phase);
        if (pv != null) {
            if (!pv.canShow()) {
                return false;
            }
            pv.getViewPanel();
            pv.afterCreate();
            new UcSetView().exec(pv);
            currPhaseView = pv;
            EventQueue.invokeLater(() -> pv.afterShow());
            return true;
        }
        return false;
    }

}
