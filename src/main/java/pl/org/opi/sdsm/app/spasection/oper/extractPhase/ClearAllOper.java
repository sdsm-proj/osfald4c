package pl.org.opi.sdsm.app.spasection.oper.extractPhase;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.ExtractViewPanel;

public class ClearAllOper {

    private final ExtractViewPanel viewPanel;

    public ClearAllOper(ExtractViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() {
        viewPanel.getListDocumentsModel().clear();
        viewPanel.getListSectionsModel().clear();
        viewPanel.getTreePart().setModel(null);
        viewPanel.getEdSelectedPart().setText("");
        _SpaSectionGenUtil.getModel().getOperCache().setSectionFldName(null);
        _SpaSectionGenUtil.getModel().getOperCache().setSelectedSectionPart(null);
    }

}
