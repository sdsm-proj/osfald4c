package pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.util.fileDir.FileChooserFilterJson;
import pl.org.opi.util.fileDir.FileChooserUtils;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import javax.swing.*;
import java.io.File;

@Slf4j
public class ActOpenPrj {
  
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

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(FileChooserUtils.getLastSelectedPath()));
        fileChooser.setCurrentDirectory(new File("D:\\osf-ncn-nawa-back\\_sdsm")); // TODO Usuń
        fileChooser.addChoosableFileFilter(new FileChooserFilterJson());
        int result = fileChooser.showOpenDialog(null);
        FileChooserUtils.setLastSelectedPath(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            new UcOpenPrj(selectedFile.getAbsolutePath()).exec();
        }
    }
    
}
