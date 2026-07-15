package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.steps;

import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps._StepBase;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;

import static pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.steps.Vars.*;

public class Step2110GenInputOutputGraphQL extends _StepBase {

    private final EnumInOut inOut;

    public Step2110GenInputOutputGraphQL(EnumInOut inOut) {
        this.inOut = inOut;
    }

    @Override
    protected void execCore() throws Exception {
        var objectNodes = _getModel().getScenario02Model().getSelectedPartNode().getObjectNodes();
        for(var on: objectNodes) {
            gen(on);
        }
    }

    private void calcVars(MetaNode metaNode) {
        _getVars().put(GRAPH_QL_INPUT_SUFFIX, "Input");
        _getVars().put(GRAPH_QL_OUTPUT_SUFFIX, "Output");
        _getVars().put(GRAPH_QL_INPUT_TYPE, "input");
        _getVars().put(GRAPH_QL_OUTPUT_TYPE, "type");

        _getVars().put(GRAPH_QL_INPUT_TYPE_NAME, (_getConfig().isInputOutputWithPrefix() ? metaNode.getPrefixedSimpleName() : metaNode.getFldClassSimpleName()));

    }

    private String inOutSuffix() {
        if (inOut.equals(EnumInOut.INPUT)) {
            return _getVars().get(GRAPH_QL_INPUT_SUFFIX);
        } else if (inOut.equals(EnumInOut.OUTPUT)) {
            return _getVars().get(GRAPH_QL_OUTPUT_SUFFIX);
        }
        return null;
    }

    private String inOutType() {
        if (inOut.equals(EnumInOut.INPUT)) {
            return _getVars().get(GRAPH_QL_INPUT_TYPE);
        } else if (inOut.equals(EnumInOut.OUTPUT)) {
            return _getVars().get(GRAPH_QL_OUTPUT_TYPE);
        }
        return null;
    }

    private String gen(MetaNode metaNode) {
        calcVars(metaNode);

        String s = "";
        s += inOutType();
        s += " ";
        s += (_getConfig().isInputOutputWithPrefix() ? metaNode.getPrefixedSimpleName() : metaNode.getFldClassSimpleName()) + inOutSuffix() + " {" + "\n";
        for(var f: metaNode.getSubs()) {
            s += "    " + f.getFldName() + ": " + getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f) + "\n";
        }
        s += "}" + "\n";
        System.out.println(s);
        return s;
    }

    private String getFldTypeAsStr(MetaNode.EnumFldVariant variant, String simpleName, MetaNode node) {
        String typeAsStr = "";
        switch(variant) {
            case PRIMITIVE:
            case SIMPLE:
                if ("boolean".equalsIgnoreCase(simpleName)) {
                    typeAsStr = "Boolean";
                } else {
                    typeAsStr = "String";
                }
                break;
            case DOMAIN_OBJECT:
                typeAsStr = simpleName;
                if (_getModel().getScenario02Model().getClassDepot().existsClass(node.getFldClassCanonicalName())) {
                    typeAsStr += inOutSuffix();
                }
                break;
            case LIST:
                typeAsStr = "[" + getFldTypeAsStr(node.getVariantGenericType(), simpleName,node) + "]";
                break;
        }
        return typeAsStr;
    }

}
