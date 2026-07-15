package pl.org.opi.sdsm.app.spasection.oper.extractPhase;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.oper.other.LoadClassesOper;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.ClazzListElem;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.util.classdepot.ClassCuComplex;

import javax.swing.*;

public class FillClassesAndDocumentsOper {

    private final ExtractViewPanel viewPanel;

    public FillClassesAndDocumentsOper(ExtractViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() throws Exception {
        new LoadClassesOper().exec();
        var dokumenty = _SpaSectionGenUtil.getModel().getOperCache().getClassDepot().wyszukajDokumenty();
        for(ClassCuComplex d: dokumenty) {
            viewPanel.getListDocumentsModel().addElement(new ClazzListElem(d.getClazz()));
        }
        viewPanel.getListDocuments().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
