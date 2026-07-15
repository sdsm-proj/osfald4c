package pl.org.opi.sdsm.frmwk.util.fileSave;

import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import java.io.File;
import java.io.IOException;

public class FileSave {

    public static final String UTF_8 = "UTF-8";
    
    public static boolean save(String relativePath, String shortFileName, String content, boolean confirmOverwrite) throws IOException {
        String absoluteFilePath = SdsmCtx.getInstance().getCurrGen().getModel().getPrjRootPath();
        absoluteFilePath += relativePath;
        absoluteFilePath += shortFileName;

        if (confirmOverwrite) {
            File f = new File(absoluteFilePath);
            if (f.exists()) {
                if (!OsfaldMsgBox.yesNo("Do you want to overwrite file:\n" + absoluteFilePath)) {
                    return false;
                }
            }
        }

        FileUtils.write(new File(absoluteFilePath), content, UTF_8);

        return true;
    }

}
