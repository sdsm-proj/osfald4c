package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java;

import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;

import java.io.File;

public class _JavaGenUtils {

    public static String fullClassName2FullFileName(String fullClassName) {
        String srcFolder = _SpaSectionGenUtil.getModel().getPrjRootPath()
                + _SpaSectionGenUtil.getModel().getConfigPrjLevel().getSourceSubPath();
        String package2File = StringUtils.replace(fullClassName, ".", "/");
        String rslt = new File(srcFolder).getAbsolutePath() + "/" + package2File + ".java";
        return new File(rslt).getAbsolutePath();
    }

    public static String getFldDefAsStr(MetaNode f, String classSuffix) {
        String s = "";
        s += "private ";

        switch (f.getVariant()) {
            case PRIMITIVE, SIMPLE -> {
                s += getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f, classSuffix);
                s += " ";
                s += f.getFldName();
            }
            case DOMAIN_OBJECT -> {
                s += getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f, classSuffix);
                s += " ";
                s += f.getFldName();
                s += " = new ";
                s += getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f, classSuffix);
                s += "()";
            }
            case LIST -> {
                s += "List<";
                s += getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f, classSuffix);
                s += ">";
                s += " ";
                s += f.getFldName();
                s += " = new ArrayList<>()";
            }
        }

        return s;
    }

    public static String getFldTypeAsStr(MetaNode.EnumFldVariant variant, String simpleName, MetaNode node, String classSuffix) {
        String typeAsStr = "";
        switch (variant) {
            case PRIMITIVE:
            case SIMPLE:
//                if ("boolean".equalsIgnoreCase(simpleName)) {
//                    typeAsStr = "boolean";
//                } else {
//                    typeAsStr = "String";
//                }
                typeAsStr = "String";
                break;
            case DOMAIN_OBJECT:
                typeAsStr = simpleName;
                if (_SpaSectionGenUtil.getModel().getOperCache().getClassDepot().existsClass(node.getFldClassCanonicalName())) {
                    typeAsStr += classSuffix;
                }
                break;
            case LIST:
                typeAsStr = getFldTypeAsStr(node.getVariantGenericType(), simpleName, node, classSuffix);
                break;
        }
        return typeAsStr;
    }

}
