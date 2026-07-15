package pl.org.opi.sdsm.app.spasection.oper.extractPhase;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.ExtractViewPanel;
import pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui.FldDefListElem;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.app.vuespringsection.util.KlazzUtil;
import pl.org.opi.util.classdepot.ClassDepot;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class FillTree4SelectedSectionOper {

    private final ExtractViewPanel viewPanel;

    private final ClassDepot classDepot;

    public FillTree4SelectedSectionOper(ExtractViewPanel viewPanel) {
        this.viewPanel = viewPanel;
        this.classDepot = _SpaSectionGenUtil.getModel().getOperCache().getClassDepot();
    }

    public void exec() {
        viewPanel.getTreePart().setModel(null);
        FldDefListElem selElem = (FldDefListElem) viewPanel.getListSections().getSelectedValue();
        if (selElem != null) {
            if (selElem.getFldDef() != null) {
                _SpaSectionGenUtil.getModel().getOperCache().setSectionFldName(selElem.getFldDef().getName());
                MetaNode metaNode = fillFields(selElem.getFldDef());
                this.viewPanel.getTreePart().setModel(new DefaultTreeModel(fillTreeNodes(metaNode)));
            }
        }
        viewPanel.getTreePart().getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        viewPanel.getEdSelectedPart().setText("");
        _SpaSectionGenUtil.getModel().getOperCache().setSelectedSectionPart(null);
    }

    private MetaNode fillFields(Field _fldDef) {
        MetaNode metaNode = fillFieldsRecur(_fldDef, null);
        return metaNode;
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

    private MetaNode fillFieldsRecur(Field _fldDef, MetaNode _parentNode) {
        _fldDef.setAccessible(true);
        MetaNode node = new MetaNode();
        node.setParentNode(_parentNode);
        node.setVariant(getTypeVariant(_fldDef.getType()));
        node.setFldName(_fldDef.getName());
        node.setFldClass(_fldDef.getType());
        node.setFldClassCanonicalName(_fldDef.getType().getCanonicalName());
        node.setFldClassSimpleName(_fldDef.getType().getSimpleName());

        if (node.getVariant().equals(MetaNode.EnumFldVariant.DOMAIN_OBJECT)) { // *********************************************
            Field[] fields = _fldDef.getType().getDeclaredFields();
            for (Field f : fields) {
                node.getSubs().add(fillFieldsRecur(f, node));
            }
        } else if (node.getVariant().equals(MetaNode.EnumFldVariant.LIST)) { // ****************************************
            if (_fldDef.getGenericType() instanceof ParameterizedType pt) {
                Class<?> listElemType = (Class<?>) pt.getActualTypeArguments()[0];
                node.setFldClass(listElemType);
                node.setFldClassCanonicalName(listElemType.getCanonicalName());
                node.setFldClassSimpleName(listElemType.getSimpleName());
                node.setVariantGenericType(getTypeVariant(listElemType));
                if (getTypeVariant(listElemType).equals(MetaNode.EnumFldVariant.DOMAIN_OBJECT)) {
                    Field[] fields = listElemType.getDeclaredFields();
                    for (Field f : fields) {
                        node.getSubs().add(fillFieldsRecur(f, node));
                    }
                }
            }
        }
        return node;
    }

    private DefaultMutableTreeNode fillTreeNodes(MetaNode rootMetaNode) {
        DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode(rootMetaNode);
        fillTreeNodesRcr(rootMetaNode, rootTreeNode);
        return rootTreeNode;
    }

    private void fillTreeNodesRcr(MetaNode parentMetaNode, DefaultMutableTreeNode parentTreeNode) {
        for(var jnode: parentMetaNode.getSubs()) {
            var newTreeNode = new DefaultMutableTreeNode(jnode);
            parentTreeNode.add(newTreeNode);
            fillTreeNodesRcr(jnode, newTreeNode);
        }
    }

}
