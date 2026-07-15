package pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.gen.Gen;
import pl.org.opi.sdsm.frmwk.mechanics.genmodel.BaseGenModel;
import pl.org.opi.sdsm.frmwk.mechanics.prjFactory.PrjFactory;
import pl.org.opi.sdsm.frmwk.mechanics.ux.dialog.newPrj.DialogNewPrjDto;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Slf4j
public class UcNewPrj {

    public UcNewPrj(DialogNewPrjDto dialogDto) {
        this.dialogDto = dialogDto;
    }

    private final DialogNewPrjDto dialogDto;

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

        // Save ...
        Gen gen = PrjFactory.createNewPrj(dialogDto.getGenDef().getPrjCode(), dialogDto.getPrjFullFileName());
        BaseGenModel model = gen.getModel();
        model.setPrjShortName(dialogDto.getPrjShortName());
        gen.save();
        
        // ... and Open
        new UcOpenPrj(dialogDto.getPrjFullFileName()).exec();
    }

}
