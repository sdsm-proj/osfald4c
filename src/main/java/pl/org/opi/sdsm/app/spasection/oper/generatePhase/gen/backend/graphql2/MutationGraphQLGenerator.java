package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.graphql2;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.util.genartifactdepot.GenArtifact;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;

public class MutationGraphQLGenerator {

    public void exec() {
        gen(_SpaSectionGenUtil.getModel().getOperCache().getSelectedSectionPart());
    }

    private void gen(MetaNode metaNode) {
        var configModel = _SpaSectionGenUtil.getModel().getConfigPrjLevel();

        String s = "";
//        s += configModel.getRw();
//        s += configModel.getMutationPrefixDlaDokumentu();
        s += _SpaSectionGenUtil.getModel().getEditSectionLevel().getRolePrefix();
        s += metaNode.getPrefixedSimpleName();
        s += "(";
        if (1 == 1) {
            s += "blokada: BlokadaInput, ";
        }
        s += "input: ";
        s += (metaNode.getFldClassSimpleName()) + "Input";
        s += "): String";

        insertArtifact(s);
    }

    protected void insertArtifact(String genCode) {
        GenArtifact ga = new GenArtifact();

        ga.setFrontBack(GenArtifact.EnumFrontBack.BACKEND);
        ga.setLanguage(GenArtifact.EnumLanguage.GRAPH_QL);
        ga.setFullPart(GenArtifact.EnumFullPart.PART);
        ga.setArtifactDisplayName("mutation");
        ga.setSrcFullPath(null);
        ga.setSrcFile(null);
        ga.setGenCode(genCode);

        _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot().add(ga);
    }


}
