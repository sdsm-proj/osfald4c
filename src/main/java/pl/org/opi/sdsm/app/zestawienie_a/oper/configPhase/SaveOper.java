package pl.org.opi.sdsm.app.zestawienie_a.oper.configPhase;

import lombok.RequiredArgsConstructor;
import pl.org.opi.util.fileDir.FileDirNormalizeName;
import pl.org.opi.sdsm.app.zestawienie_a._ZestawienieAUtil;
import pl.org.opi.sdsm.app.zestawienie_a.stru.configPhase.ui.ZaConfigViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class SaveOper {

    private final ZaConfigViewPanel viewPanel;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() throws Exception {
        var cm = _ZestawienieAUtil.getModel().getConfigModel();

        cm.setPrjFrontFullPath (viewPanel.getEdPrjFrontFullPath().getText().trim());
        cm.setPrjContractFullPath (viewPanel.getEdPrjContractFullPath().getText().trim());
        cm.setPrjBackendFullPath (viewPanel.getEdPrjBackendFullPath().getText().trim());
        cm.setPrjBackendGenFullPath (viewPanel.getEdPrjBackendGenFullPath().getText().trim());

        adjustData();
        _ZestawienieAUtil.getGen().save();
        new LoadOper(viewPanel).exec();
    }

    private void adjustData() {
        var cm = _ZestawienieAUtil.getModel().getConfigModel();
        cm.setPrjFrontFullPath(FileDirNormalizeName.normalizePathName(cm.getPrjFrontFullPath()));
        cm.setPrjContractFullPath(FileDirNormalizeName.normalizePathName(cm.getPrjContractFullPath()));
        cm.setPrjBackendFullPath(FileDirNormalizeName.normalizePathName(cm.getPrjBackendFullPath()));
        cm.setPrjBackendGenFullPath(FileDirNormalizeName.normalizePathName(cm.getPrjBackendGenFullPath()));
    }

}
