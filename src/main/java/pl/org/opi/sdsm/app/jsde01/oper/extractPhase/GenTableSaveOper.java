package pl.org.opi.sdsm.app.jsde01.oper.extractPhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.app.jsde01._Jsde01GenUtil;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class GenTableSaveOper {

    private final StepPanel stepPanel;

    private final ObjectMapper om = new ObjectMapper();

    public void exec() {
        try {
            _Jsde01GenUtil.getModel().getExtractModel().setGenTableSqlCreate(stepPanel.getTextPane2().getText().trim());
            SdsmCtx.getInstance().getCurrGen().save();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
