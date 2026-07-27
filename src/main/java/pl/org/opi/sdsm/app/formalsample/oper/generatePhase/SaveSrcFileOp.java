package pl.org.opi.sdsm.app.formalsample.oper.generatePhase;

import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.formalsample.stru.generatePhase.ui.GenerateViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class SaveSrcFileOp {
    public void exec(GenerateViewPanel viewPanel) {
        try {
            String code = viewPanel.getTaSrcCode().getText().trim();
            File file = new File(viewPanel.getEdJavaFileName().getText().trim());
            FileUtils.writeStringToFile(file, code, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }
}
