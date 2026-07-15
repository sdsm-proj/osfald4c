package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.graphql2;

import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.AbstractGenerator;
import pl.org.opi.util.genartifactdepot.GenArtifact;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;

public abstract class AbstractInputOutputGraphQLGenerator extends AbstractGenerator {

    public final String GRAPH_QL_INPUT_SUFFIX = "Input";
    public final String GRAPH_QL_OUTPUT_SUFFIX = "Output";
    public final String GRAPH_QL_INPUT_TYPE = "input";
    public final String GRAPH_QL_OUTPUT_TYPE = "type";

    protected String getFldTypeAsStr(MetaNode.EnumFldVariant variant, String simpleName, MetaNode node, String inOutSuffix) {
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
                if (getMdxClassDepot().existsClass(node.getFldClassCanonicalName())) {
                    typeAsStr += inOutSuffix;
                }
                break;
            case LIST:
                typeAsStr = "[" + getFldTypeAsStr(node.getVariantGenericType(), simpleName, node, inOutSuffix) + "]";
                break;
        }
        return typeAsStr;
    }

    protected void insertArtifact(String gqlClassName, String genCode) {
        GenArtifact ga = new GenArtifact();

        ga.setFrontBack(GenArtifact.EnumFrontBack.BACKEND);
        ga.setLanguage(GenArtifact.EnumLanguage.GRAPH_QL);
        ga.setFullPart(GenArtifact.EnumFullPart.PART);
        ga.setArtifactDisplayName(gqlClassName);
        ga.setSrcFullPath(null);
        ga.setSrcFile(null);
        ga.setGenCode(genCode);

        getMdxArtifactDepot().add(ga);
    }

}
