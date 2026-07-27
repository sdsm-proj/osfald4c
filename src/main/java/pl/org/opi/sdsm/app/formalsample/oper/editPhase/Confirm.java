package pl.org.opi.sdsm.app.formalsample.oper.editPhase;

import pl.org.opi.sdsm.app.formalsample._FormalSampleGenUtil;
import pl.org.opi.sdsm.app.formalsample.stru.editPhase.ui.EditViewPanel;

public class Confirm {
    public void exec(EditViewPanel viewPanel) {
        _FormalSampleGenUtil.getModel().getFinalModel().setTableName(
                _FormalSampleGenUtil.getModel().getRawModel().getTableName()
        );
        _FormalSampleGenUtil.getModel().getFinalModel().setFields(
                viewPanel.getTaFieldsEdited().getText().trim()
        );
        _FormalSampleGenUtil.getGen().save();
    }
}
