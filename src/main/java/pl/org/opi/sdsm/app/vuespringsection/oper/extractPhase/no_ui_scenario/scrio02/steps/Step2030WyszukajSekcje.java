package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.steps;

import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps._StepBase;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.app.vuespringsection.util.KlazzUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class Step2030WyszukajSekcje extends _StepBase {

    @Override
    protected void execCore() throws Exception {
        var cux = _getModel().getScenario02Model().getDokumentCux();
        Class<?> dokClazz = cux.getClazz();
        for (Field fldDef : dokClazz.getDeclaredFields()) {
            fldDef.setAccessible(true);
            Class<?> fldClazz = fldDef.getType();
            String canName = fldClazz.getCanonicalName();
            //if (canName.startsWith("java.lang")) continue;
            //System.out.println(canName);

            boolean goInto = false;

            if (_getModel().getScenario02Model().getClassDepot().existsClass(canName)) {
                goInto = true;
            }

            if (getTypeVariant(fldDef.getType()).equals(MetaNode.EnumFldVariant.LIST)) {
                if (fldDef.getGenericType() instanceof ParameterizedType pt) {
                    Class<?> listElemType = (Class<?>) pt.getActualTypeArguments()[0];
                    if (getTypeVariant(listElemType).equals(MetaNode.EnumFldVariant.DOMAIN_OBJECT)) {
                        if (_getModel().getScenario02Model().getClassDepot().existsClass(listElemType.getCanonicalName())) {
                            goInto = true;
                        }
                    }
                }
            }

            if (goInto) {
                if (fldDef.getName().equals("panOsfaldAiB")) {
                    fillFields(fldDef);
                }
            }
        }
        int dbg = 1;
    }

    private MetaNode metaNode = null;

    private void fillFields(Field _fldDef) {
        metaNode = fillFieldsRecur(_fldDef, null);
        _getModel().getScenario02Model().setEntireSectionNode(metaNode);

        //_getModel().getScenario02Model().setSelectedPartNode(javaNode.getSubs().get(0));    // !!!!!!!!!!!!!!!!!!!!!!!!!
        _getModel().getScenario02Model().setSelectedPartNode(metaNode);    // !!!!!!!!!!!!!!!!!!!!!!!!!

        System.out.println("---------- Cała sekcja ------------------------------------------------------------------");
        _getModel().getScenario02Model().getEntireSectionNode().showMe();
        System.out.println("");

        System.out.println("---------- Do edycji --------------------------------------------------------------------");
        _getModel().getScenario02Model().getSelectedPartNode().showMe();
        System.out.println("");

    }

    private MetaNode.EnumFldVariant getTypeVariant(Class<?> _fldType) {
        if (KlazzUtil.getAllExtendedOrImplementedInterfacesRecursively(_fldType).contains(java.util.Collection.class)) {
            return MetaNode.EnumFldVariant.LIST;
        } else if (_fldType.getCanonicalName().startsWith("java.lang")) {
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
        } else if (_getModel().getScenario02Model().getClassDepot().existsClass(_fldType.getCanonicalName())) {
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

        System.out.println("----------> " + _fldDef.getName());

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

}
