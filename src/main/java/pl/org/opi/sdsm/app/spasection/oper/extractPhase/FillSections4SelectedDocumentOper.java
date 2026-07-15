package pl.org.opi.sdsm.app.spasection.oper.extractPhase;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.ClazzListElem;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.FldDefListElem;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.app.vuespringsection.util.KlazzUtil;
import pl.org.opi.util.classdepot.ClassDepot;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class FillSections4SelectedDocumentOper {

    private final ExtractViewPanel viewPanel;

    private final ClassDepot classDepot;

    public FillSections4SelectedDocumentOper(ExtractViewPanel viewPanel) {
        this.viewPanel = viewPanel;
        this.classDepot = _SpaSectionGenUtil.getModel().getOperCache().getClassDepot();
    }

    public void exec() {
        viewPanel.getListSectionsModel().clear();
        ClazzListElem sel = (ClazzListElem) this.viewPanel.getListDocuments().getSelectedValue();
        if (sel == null) {
            System.out.println("doc empty");
        } else {
            System.out.println("doc " + sel);
            findSections(sel.getClazz());
        }
        viewPanel.getListSections().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        viewPanel.getEdSelectedPart().setText("");
        _SpaSectionGenUtil.getModel().getOperCache().setSelectedSectionPart(null);
    }

    private void findSections(Class<?> documentClass) {
        for (Field fldDef : documentClass.getDeclaredFields()) {
            fldDef.setAccessible(true);
            Class<?> fldClazz = fldDef.getType();
            String canName = fldClazz.getCanonicalName();

            boolean goInto = false;

            if (classDepot.existsClass(canName)) {
                goInto = true;
            }

            if (getTypeVariant(fldDef.getType()).equals(MetaNode.EnumFldVariant.LIST)) {
                if (fldDef.getGenericType() instanceof ParameterizedType pt) {
                    Class<?> listElemType = (Class<?>) pt.getActualTypeArguments()[0];
                    if (getTypeVariant(listElemType).equals(MetaNode.EnumFldVariant.DOMAIN_OBJECT)) {
                        if (classDepot.existsClass(listElemType.getCanonicalName())) {
                            goInto = true;
                        }
                    }
                }
            }

            if (goInto) {
                viewPanel.getListSectionsModel().addElement(new FldDefListElem(fldDef));
            }

        }

    }

    private MetaNode.EnumFldVariant getTypeVariant(Class<?> _fldType) {
        if (KlazzUtil.getAllExtendedOrImplementedInterfacesRecursively(_fldType).contains(java.util.Collection.class)) {
            return MetaNode.EnumFldVariant.LIST;
        } else if (_fldType.getCanonicalName().startsWith("java.lang")) {
            return MetaNode.EnumFldVariant.SIMPLE;
        } else if (_fldType.getCanonicalName().startsWith("java.time")) {
            return MetaNode.EnumFldVariant.SIMPLE;
        } else if (_fldType.isPrimitive()) {
            return MetaNode.EnumFldVariant.PRIMITIVE;
        } else if (_fldType.isEnum()) {
            return MetaNode.EnumFldVariant.ENUM;
        } else if (_fldType.getSimpleName().equalsIgnoreCase("LocalDictionaryItemInput")) {
            return MetaNode.EnumFldVariant.LOCAL_DICTIONARY_ITEM_INPUT;
        } else if (_fldType.getSimpleName().equalsIgnoreCase("LocalDictionaryItemOutput")) {
            return MetaNode.EnumFldVariant.LOCAL_DICTIONARY_ITEM_OUTPUT;
        } else if (_fldType.getSimpleName().equalsIgnoreCase("LocalDictionaryItemRef")) {
            return MetaNode.EnumFldVariant.LOCAL_DICTIONARY_ITEM_REF;
        } else if (classDepot.existsClass(_fldType.getCanonicalName())) {
            return MetaNode.EnumFldVariant.DOMAIN_OBJECT;
        }
        return MetaNode.EnumFldVariant.OTHER_OBJECT;
    }


}
