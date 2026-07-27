package pl.org.opi.sdsm.app.formalsample.oper.configPhase;

import io.micrometer.common.util.StringUtils;
import pl.org.opi.sdsm.app.formalsample._FormalSampleGenUtil;
import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.util.fileDir.FileChooserUtils;

import javax.swing.*;
import java.io.File;

public class SelectSqlFileOp {
    public void exec() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(FileChooserUtils.getLastSelectedPath()));
        if (StringUtils.isNotBlank(_FormalSampleGenUtil.getModel().getConfigModel().getNazwaPlikuSql())) {
            fileChooser.setSelectedFile(new File(_FormalSampleGenUtil.getModel().getConfigModel().getNazwaPlikuSql()));
        }
        int result = fileChooser.showSaveDialog(AppCtx.getInstance().getMainWindow());
        FileChooserUtils.setLastSelectedPath(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String absName = selectedFile.getAbsolutePath();
            if (StringUtils.isNotBlank(absName)) {
                _FormalSampleGenUtil.getModel().getConfigModel().setNazwaPlikuSql(absName);
                _FormalSampleGenUtil.getGen().save();
            }
        }
    }
}
