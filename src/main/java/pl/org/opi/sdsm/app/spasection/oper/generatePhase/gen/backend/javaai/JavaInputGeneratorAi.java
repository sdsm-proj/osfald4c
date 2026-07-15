package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.javaai;

import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java.ModelAccess;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java._JavaGenUtils;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.consta.GenConsta;
import pl.org.opi.util.ai.api.AiUniClient;
import pl.org.opi.util.ai.api.EnumLLM;
import pl.org.opi.util.ai.api.UniAiPrompt;
import pl.org.opi.util.ai.api.UniAiResponse;
import pl.org.opi.util.genartifactdepot.GenArtifact;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.frmwk.util.fileSave.FileSave;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JavaInputGeneratorAi {

    public JavaInputGeneratorAi(EnumLLM llm) {
        this.llm = llm;
    }

    private final EnumLLM llm;

    private final ModelAccess mda = new ModelAccess();

    public void exec() throws IOException {
        var partObjectNodes = _SpaSectionGenUtil.getModel().getOperCache().getSelectedSectionPart().getObjectNodes();
        mda.getGenVars().getJavaInputClassDefs().clear();
        boolean appendDocumentId = true;
        for(var partNode: partObjectNodes) {
            gen(partNode, appendDocumentId);
            appendDocumentId = false;
        }
    }

    private void gen(MetaNode metaNode, boolean appendDocumentId) throws IOException {
        String domainClassSimple = metaNode.getFldClassSimpleName();
        String domainClassCanonical = metaNode.getFldClassCanonicalName();
        String domainFileName = _JavaGenUtils.fullClassName2FullFileName(domainClassCanonical);
        String domainClassStr = FileUtils.readFileToString(new File(domainFileName), FileSave.UTF_8);

        String genSimpleClass = (metaNode.getFldClassSimpleName() + GenConsta.INPUT_CLASS_SUFFIX);

        Map<String, Object> params = new HashMap<>();
        params.put("domainClassSimple", domainClassSimple);
        params.put("domainClassStr", domainClassStr);
        params.put("fullPackage", mda.getGenVars().getJavaInputFullPackage());

        VelTempl t = new VelTempl("gen/backend/javaai/JavaInputGeneratorAi_03.vm", params);
        String promptMessage = t.build();

        UniAiPrompt prompt = new UniAiPrompt();
        prompt.addParagraph(promptMessage);
        if (appendDocumentId) {
            VelTempl t2 = new VelTempl("gen/backend/javaai/JavaInputGeneratorAi_01_documentId.vm", params);
            prompt.addParagraph(t2.build());
        }

        VelTempl t3 = new VelTempl("gen/backend/javaai/JavaInputGeneratorAi_01_package.vm", params);
        prompt.addParagraph(t3.build());


        UniAiResponse response = AiUniClient.call(prompt, this.llm);

        GenArtifact ga = mda.getArtifactDepot().getArtifacts().stream().filter((GenArtifact a) -> a.getArtifactDisplayName().equals(genSimpleClass)).findFirst().get();
        if (ga != null) {
            String genCodeAi = "";
            for(String chk: response.getJavaChunks()) {
                genCodeAi += chk;
                genCodeAi += "\n\n";
            }

            // ga.setGenCodeAi(response.getJavaFirstChunk());
            ga.setGenCodeAi(genCodeAi);
        }

        String all = ga.getGenCodeAi();

        all += "\n\n";
        all += "******************************************************************************";
        all += "******************************************************************************";
        all += "\n\n";
        all += response.getFullAnswer();
        ga.setGenCodeAi(all);


        int dbg = 1;
    }


}
