package pl.org.opi.sdsm.app.frontenddto.oper.generatePhase;

import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class TypeAndConstPrepareOper {

    private final StepPanel stepPanel;

    public void exec() {
        try {
            System.out.println("TypeAndConstPrepareOper");
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
