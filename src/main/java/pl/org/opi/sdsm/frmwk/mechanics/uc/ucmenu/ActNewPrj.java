package pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.ux.dialog.newPrj.DialogNewPrj;
import pl.org.opi.sdsm.frmwk.mechanics.ux.dialog.newPrj.DialogNewPrjDto;
import pl.org.opi.sdsm.frmwk.mechanics.ux.dialog.newPrj.DialogNewPrjSubmit;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class ActNewPrj implements DialogNewPrjSubmit {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() {
        new UcClosePrj().exec();

        DialogNewPrj dlg = new DialogNewPrj(this);
        dlg.setVisible(true);
    }

    @Override
    public void onDialogOk(DialogNewPrjDto dialogDto) {
        new UcNewPrj(dialogDto).exec();
    }

}
