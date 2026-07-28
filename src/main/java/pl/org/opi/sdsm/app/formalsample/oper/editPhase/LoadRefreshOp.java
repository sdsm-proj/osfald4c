package pl.org.opi.sdsm.app.formalsample.oper.editPhase;

import pl.org.opi.sdsm.app.formalsample._FormalSampleGenUtil;
import pl.org.opi.sdsm.app.formalsample.stru.editPhase.ui.EditViewPanel;

public class LoadRefreshOp {
    public void exec(EditViewPanel viewPanel) {
        viewPanel.getTaFieldsEdited().setText(_FormalSampleGenUtil.getModel().getRawModel().getFields());
    }
}
