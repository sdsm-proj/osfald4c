package pl.org.opi.sdsm.app.zestawienie_a.oper.extractPhase;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.zestawienie_a._ZestawienieAUtil;
import pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase.ui.ComboItem;
import pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase.ui.ZaExtractViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
public class RelaodOper {

    private final ZaExtractViewPanel viewPanel;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() throws IOException {
        loadAll();
    }

    private void loadAll() throws IOException {
        viewPanel.getComboModel().removeAllItems();
        viewPanel.getComboCtrl().removeAllItems();

        viewPanel.getComboModel().addItem("");
        viewPanel.getComboCtrl().addItem("");

        String backendGenFullPath = _ZestawienieAUtil.getModel().getConfigModel().getPrjBackendGenFullPath();
        var files = FileUtils.listFiles(new File(backendGenFullPath), new String[]{"java"}, true);
        for(File file: files) {
            System.out.println(file.getCanonicalPath());
            String fname = file.getCanonicalPath();

            if ((fname.contains("\\model\\")) || (fname.contains("/model/"))) {
                 viewPanel.getComboModel().addItem(new ComboItem(file.getName().replace(".java", ""), file));
            } else if ((fname.contains("\\api\\")) || (fname.contains("/api/"))) {
                viewPanel.getComboCtrl().addItem(new ComboItem(file.getName().replace(".java", ""), file));
            }
        }
    }

}
