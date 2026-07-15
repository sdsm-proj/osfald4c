package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.graphql2ai;

import graphql.language.Definition;
import graphql.language.Document;
import graphql.language.TypeDefinition;
import graphql.parser.Parser;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java.ModelAccess;
import pl.org.opi.util.ai.api.*;
import pl.org.opi.util.genartifactdepot.GenArtifact;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputGraphQLGeneratorAi {

    public InputGraphQLGeneratorAi(EnumLLM llm) {
        this.llm = llm;
    }

    private final EnumLLM llm;

    private final ModelAccess mda = new ModelAccess();

    public void exec() throws IOException {
        var depot = mda.getArtifactDepot();

        Map<String, Object> params = new HashMap<>();
        params.put("domainClassSimple", "");

        VelTempl t = new VelTempl("gen/backend/javaai/InputGraphQLGeneratorAi.vm", params);
        String promptMessage = t.build();

        UniAiPrompt prompt = new UniAiPrompt();
        prompt.addParagraph(promptMessage);

        List<GenArtifact> gaList = mda.getArtifactDepot().getArtifacts().stream().filter((GenArtifact a) -> a.getLanguage().equals(GenArtifact.EnumLanguage.JAVA)).toList();
        for(GenArtifact ga: gaList) {
//            if (ga.getArtifactDisplayName().endsWith("Input")) {
//                prompt.addParagraph(ga.getGenCode(), ConstaProgLang.BAQ3_JAVA);
//            }

            if (ga.getArtifactDisplayName().endsWith("Input")) {
                prompt.addParagraph(ga.getGenCode(), ConstaProgLang.BAQ3_JAVA);
            }

        }

        UniAiResponse response = AiUniClient.call(prompt, this.llm);

        System.out.println("*****************************************************************************************");
        System.out.println("*****************************************************************************************");
        System.out.println(response.getFullAnswer());
        System.out.println("*****************************************************************************************");
        System.out.println("*****************************************************************************************");

        Parser parser = new Parser();

        for(var chunk: response.getGraphQLChunks()) {
            Document gqlDoc = parser.parseDocument(chunk);

            TypeDefinition def1 = (TypeDefinition) gqlDoc.getDefinitions().getFirst();
            String debugName = def1.getName();

            GenArtifact ga = mda.getArtifactDepot().getArtifacts().stream().filter(
                    (GenArtifact a) ->
                            (a.getArtifactDisplayName().equals(def1.getName()) && a.getLanguage().equals(GenArtifact.EnumLanguage.GRAPH_QL))
            ).findFirst().get();
            if (ga != null) {
                ga.setGenCodeAi(chunk);
            }
        }

        int dbg = 1;
    }

}
