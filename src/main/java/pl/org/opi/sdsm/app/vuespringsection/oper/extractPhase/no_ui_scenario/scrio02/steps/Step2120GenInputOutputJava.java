package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.steps;

import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps._StepBase;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;

public class Step2120GenInputOutputJava extends _StepBase {

    private final EnumInOut inOut;

    public Step2120GenInputOutputJava(EnumInOut inOut) {
        this.inOut = inOut;
    }

    private String inOutSuffix() {
        if (inOut.equals(EnumInOut.INPUT)) {
            return "Input";
        } else if (inOut.equals(EnumInOut.OUTPUT)) {
            return "Output";
        }
        return "????";
    }

    @Override
    protected void execCore() throws Exception {
        var objectNodes = _getModel().getScenario02Model().getSelectedPartNode().getObjectNodes();
        for(var on: objectNodes) {
            gen(on);
        }
    }

    private String gen(MetaNode metaNode) {
        String s = "";

        s += "package" + " "
                + _getConfig().getPakietInputOutputDto()
                + "."
                + _getConfig().getPakietSekcji()
                + ";" + "\n";
        s += "" + "\n";
        s += "import lombok.Data;" + "\n";
        s += "" + "\n";
        s += "@Data" + "\n";
        s += "public class " + (_getConfig().isInputOutputWithPrefix() ? metaNode.getPrefixedSimpleName() : metaNode.getFldClassSimpleName()) + inOutSuffix() + " {" + "\n";

        for(var f: metaNode.getSubs()) {
            //s += "    " + "private " + f.getFldName() + ";\n";
            s += getFldDefAsStr(f) + ";\n";
        }

        s += "}" + "\n";
        System.out.println(s);
        return s;
    }

    private String getFldDefAsStr(MetaNode f) {
        String s = "";
        s += "    ";
        s += "private ";

        switch(f.getVariant()) {
            case PRIMITIVE:
            case SIMPLE:
                s += getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f);
                s += " ";
                s += f.getFldName();
                break;
            case DOMAIN_OBJECT:
                s += getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f);
                s += " ";
                s += f.getFldName();
                s += " = new ";
                s += getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f);
                s += "()";
                break;
            case LIST:
                s += "List<";
                s += getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f);
                s += ">";
                s += " ";
                s += f.getFldName();
                s += " = new ArrayList<>()";
                break;
        }

        return s;
    }


    private String getFldTypeAsStr(MetaNode.EnumFldVariant variant, String simpleName, MetaNode node) {
        String typeAsStr = "";
        switch(variant) {
            case PRIMITIVE:
            case SIMPLE:
                if ("boolean".equalsIgnoreCase(simpleName)) {
                    typeAsStr = "boolean";
                } else {
                    typeAsStr = "String";
                }
                break;
            case DOMAIN_OBJECT:
                typeAsStr = simpleName;
                if (_getModel().getScenario02Model().getClassDepot().existsClass(node.getFldClassCanonicalName())) {
                    typeAsStr += "Output";
                }
                break;
            case LIST:
                typeAsStr = getFldTypeAsStr(node.getVariantGenericType(), simpleName,node);
                break;
        }
        return typeAsStr;
    }


}
