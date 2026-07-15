package pl.org.opi.sdsm.frmwk.mechanics.ux.dialog.newPrj;

import lombok.Data;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.GenDef;

@Data
public class DialogNewPrjDto {
    private GenDef genDef;
    private String prjFullFileName;
    private String prjShortName;
}
