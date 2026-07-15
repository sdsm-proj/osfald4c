package pl.org.opi.sdsm.app.frontenddto.oper.generatePhase;

import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class TypeAndConstDoItOper {

    private final StepPanel stepPanel;

    public void exec() {
        try {
            System.out.println("TypeAndConstDoItOper");
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

}
