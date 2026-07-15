package pl.org.opi.sdsm.app.spasection.oper.editPhase;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.stru.editPhase.ui.EditViewPanel;
import pl.org.opi.sdsm.frmwk.util.names.NamesUtils;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class InitOper {

    private final EditViewPanel viewPanel;

    public InitOper(EditViewPanel viewPanel) {
        this.viewPanel = viewPanel;
        model2View();
        verifySectionPackageName();
    }

    public void exec() {
        setFocusListener(viewPanel.getEdJavaDocumentPrefix());
        setFocusListener(viewPanel.getEdJavaDtoPackage());
        setFocusListener(viewPanel.getEdJavaMapperPackage());
        setFocusListener(viewPanel.getEdJavaServicePackage());
        setFocusListener(viewPanel.getEdJavaControllerPackage());

        setFocusListener(viewPanel.getEdSectionPackageName());
        setFocusListener(viewPanel.getEdServiceOperationNameLower());
        setFocusListener(viewPanel.getEdServiceOperationNameUpper());
        setFocusListener(viewPanel.getEdRolePrefix());
    }

    private void setFocusListener(JComponent component) {
        component.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                view2Model();
                _SpaSectionGenUtil.getGen().save();
            }
        });
    }

    private void model2View() {
        // Document level
        var dl = _SpaSectionGenUtil.getModel().getEditDocumentLevel();
        viewPanel.getEdJavaDocumentPrefix().setText(dl.getJavaDocumentPrefix());
        viewPanel.getEdJavaDtoPackage().setText(dl.getJavaDtoPackage());
        viewPanel.getEdJavaMapperPackage().setText(dl.getJavaMapperPackage());
        viewPanel.getEdJavaServicePackage().setText(dl.getJavaServicePackage());
        viewPanel.getEdJavaControllerPackage().setText(dl.getJavaControllerPackage());

        // Section level
        var sl = _SpaSectionGenUtil.getModel().getEditSectionLevel();
        viewPanel.getEdSectionPackageName().setText(sl.getSelectedSectionPartialPackage());
        viewPanel.getEdServiceOperationNameLower().setText(sl.getServiceOperationNameLower());
        viewPanel.getEdServiceOperationNameUpper().setText(sl.getServiceOperationNameUpper());
        viewPanel.getEdRolePrefix().setText(sl.getRolePrefix());
    }

    private void view2Model() {
        // Document level
        var dl = _SpaSectionGenUtil.getModel().getEditDocumentLevel();
        dl.setJavaDocumentPrefix(NamesUtils.firstLetterUpper(viewPanel.getEdJavaDocumentPrefix().getText().trim()));
        dl.setJavaDtoPackage(viewPanel.getEdJavaDtoPackage().getText().trim());
        dl.setJavaMapperPackage(viewPanel.getEdJavaMapperPackage().getText().trim());
        dl.setJavaServicePackage(viewPanel.getEdJavaServicePackage().getText().trim());
        dl.setJavaControllerPackage(viewPanel.getEdJavaControllerPackage().getText().trim());

        // Section level
        var sl = _SpaSectionGenUtil.getModel().getEditSectionLevel();
        sl.setSelectedSectionPartialPackage(viewPanel.getEdSectionPackageName().getText().trim());
        sl.setSelectedSectionPartialPackageUpper(NamesUtils.firstLetterUpper(sl.getSelectedSectionPartialPackage()));
        sl.setServiceOperationNameLower(NamesUtils.firstLetterLower(viewPanel.getEdServiceOperationNameLower().getText().trim()));
        sl.setServiceOperationNameUpper(NamesUtils.firstLetterUpper(viewPanel.getEdServiceOperationNameLower().getText().trim()));
        sl.setRolePrefix(NamesUtils.firstLetterLower(viewPanel.getEdRolePrefix().getText().trim()));
        model2View();
    }

    private void verifySectionPackageName() {
//        var editModel = _SpaSectionGenUtil.getModel().getEditSectionLevel();
//        String auto = _SpaSectionGenUtil.getModel().getOperCache().getSectionFldName();
//        if (StringUtils.isNotBlank(auto)) {
//            if (auto.equals(editModel.getSelectedSectionPartialPackageAuto())) {
//                // NOP
//            } else {
//                editModel.setSelectedSectionPartialPackageAuto(auto);
//                editModel.setSelectedSectionPartialPackage(auto);
//                model2View();
//            }
//        }
    }

}
