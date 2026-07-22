package pl.org.opi.sdsm.app.zestawienie_a.oper.editPhase;

import lombok.RequiredArgsConstructor;
import pl.org.opi.util.fileDir.FileDirNormalizeName;
import pl.org.opi.sdsm.app.zestawienie_a._ZestawienieAUtil;
import pl.org.opi.sdsm.app.zestawienie_a.stru.editPhase.ui.ZaEditViewPanel;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@RequiredArgsConstructor
public class SaveOper {

    private final ZaEditViewPanel viewPanel;

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() throws Exception {
        var em = _ZestawienieAUtil.getModel().getEditModel();
        em.setAngularComponentPath(viewPanel.getEdAngularComponentPath().getText().trim());
        em.setComponentClassName(viewPanel.getEdComponentClassName().getText().trim());
        em.setSelector(viewPanel.getEdSelector().getText().trim());
        adjustData();
        _ZestawienieAUtil.getGen().save();
        new LoadOper(viewPanel).exec();
    }

    private void adjustData() {
        var em = _ZestawienieAUtil.getModel().getEditModel();
        em.setAngularComponentPath(FileDirNormalizeName.normalizePathName(em.getAngularComponentPath()));

        var shortName = viewPanel.getEdAngularComponentFileName().getText().trim();
        em.setAngularComponentShortFileName(shortName);
        em.setAngularComponentTsFullFileName(em.getAngularComponentPath() + shortName + ".ts");
        em.setAngularComponentHtmlFullFileName(em.getAngularComponentPath() + shortName + ".html");
        em.setAngularComponentCssFullFileName(em.getAngularComponentPath() + shortName + ".css");
    }

}

