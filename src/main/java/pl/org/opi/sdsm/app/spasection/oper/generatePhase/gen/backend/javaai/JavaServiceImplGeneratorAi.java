package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.javaai;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java.ModelAccess;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;
import pl.org.opi.util.ai.api.AiUniClient;
import pl.org.opi.util.ai.api.EnumLLM;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;
import pl.org.opi.util.genartifactdepot.GenArtifact;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JavaServiceImplGeneratorAi {

    public JavaServiceImplGeneratorAi(EnumLLM llm) {
        this.llm = llm;
    }

    private final EnumLLM llm;

    private ModelAccess mda = new ModelAccess();

    public void exec() {
        gen(_SpaSectionGenUtil.getModel().getOperCache().getSelectedSectionPart());
    }

    private void gen(MetaNode metaNode) {
        Map<String, Object> params = new HashMap<>();

        String s= "";
        s += "fullPackage = " + mda.getGenVars().getJavaServiceImplClassDef().getFullPackage() + "\n";
        s += "simpleClass = " + mda.getGenVars().getJavaServiceImplClassDef().getSimpleClass() + "\n";
        s += "simpleClassIface = " +  mda.getGenVars().getJavaServiceIfaceClassDef().getSimpleClass() + "\n";
        s += "domainFullClass = " + mda.getEditSectionLevel().getDomainFullClass() + "\n";
        s += "domainSimpleClass = " + mda.getEditSectionLevel().getDomainSimpleClass() + "\n";
        s += "domainSimpleClassLower = " + mda.getEditSectionLevel().getDomainSimpleClassLower() + "\n";
        s += "serviceOperationNameLower = " + mda.getEditSectionLevel().getServiceOperationNameLower() + "\n";

        params.put("variableValues", s);

        VelTempl t = new VelTempl("gen/backend/javaai/JavaServiceImplGeneratorAi_01.vm", params);

        UniAiPrompt prompt = new UniAiPrompt();
        prompt.addParagraph(t.build());

        UniAiResponse response = AiUniClient.call(prompt, this.llm);

        GenArtifact ga = mda.getArtifactDepot().getArtifacts().stream().filter((GenArtifact a) -> a.getArtifactDisplayName().equals(
                mda.getGenVars().getJavaServiceImplClassDef().getSimpleClass()
        )).findFirst().get();
        if (ga != null) {
            String genCodeAi = "";
            for(String chk: response.getJavaChunks()) {
                genCodeAi += chk;
                genCodeAi += "\n\n";
            }

            // ga.setGenCodeAi(response.getJavaFirstChunk());
            ga.setGenCodeAi(genCodeAi);
        }

    }


}
