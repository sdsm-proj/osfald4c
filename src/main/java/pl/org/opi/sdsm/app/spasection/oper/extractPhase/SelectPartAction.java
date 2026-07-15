package pl.org.opi.sdsm.app.spasection.oper.extractPhase;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java.ModelAccess;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;
import pl.org.opi.sdsm.frmwk.util.names.NamesUtils;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class SelectPartAction {

    private ModelAccess mda = new ModelAccess();    // TODO Usuń

    private final ExtractViewPanel viewPanel;

    public SelectPartAction(ExtractViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() {
        _SpaSectionGenUtil.getModel().getOperCache().setSelectedSectionPart(null);
        viewPanel.getEdSelectedPart().setText("");

        TreePath selPath = viewPanel.getTreePart().getSelectionPath();
        if (selPath != null) {
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) selPath.getLastPathComponent();
            if (treeNode != null) {
                MetaNode metaNode = (MetaNode) treeNode.getUserObject();
                if (metaNode != null) {
                    if (metaNode.getVariant().equals(MetaNode.EnumFldVariant.DOMAIN_OBJECT)) {
                        _SpaSectionGenUtil.getModel().getOperCache().setSelectedSectionPart(metaNode);
                        viewPanel.getEdSelectedPart().setText(metaNode.getFldNamesChain());
                        {
                            var edit = mda.getEditSectionLevel();
                            edit.setDomainSimpleClass(metaNode.getFldClassSimpleName());
                            edit.setDomainSimpleClassLower(NamesUtils.firstLetterLower(metaNode.getFldClassSimpleName()));
                            edit.setDomainFullClass(metaNode.getFldClassCanonicalName());
                            edit.setDomainPackage(metaNode.getFldClass().getPackageName());
                            edit.setSelectedSectionPartialPackageAuto(edit.getDomainSimpleClassLower());
                            edit.setSelectedSectionPartialPackage(NamesUtils.firstLetterLower(edit.getSelectedSectionPartialPackageAuto()));
                            edit.setSelectedSectionPartialPackageUpper(NamesUtils.firstLetterUpper(edit.getSelectedSectionPartialPackageAuto()));
                        }
                    } else {
                        OsfaldMsgBox.warn("Select domain object");
                    }
                }
            }
        }
        _SpaSectionGenUtil.getGen().save();
    }

}
