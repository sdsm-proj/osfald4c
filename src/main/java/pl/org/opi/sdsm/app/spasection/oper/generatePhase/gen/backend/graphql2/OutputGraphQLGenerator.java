package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.graphql2;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;

public class OutputGraphQLGenerator extends AbstractInputOutputGraphQLGenerator {

    public void exec() {
        var partObjectNodes = _SpaSectionGenUtil.getModel().getOperCache().getSelectedSectionPart().getObjectNodes();
        for(var partNode: partObjectNodes) {
            gen(partNode);
        }
    }

    private void gen(MetaNode metaNode) {
        String s = "";

        String gqlClassName = metaNode.getFldClassSimpleName() + GRAPH_QL_OUTPUT_SUFFIX;
        s += GRAPH_QL_OUTPUT_TYPE;
        s += " ";
        s += gqlClassName + " {" + "\n";
        for(var f: metaNode.getSubs()) {
            s += "    " + f.getFldName() + ": " + getFldTypeAsStr(f.getVariant(), f.getFldClassSimpleName(), f, GRAPH_QL_OUTPUT_SUFFIX) + "\n";
        }
        s += "}" + "\n";

        String genCode = s;
        insertArtifact(gqlClassName, genCode);
    }

}
