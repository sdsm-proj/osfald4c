package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java;

import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.model.sub.GenVars;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.consta.GenConsta;
import pl.org.opi.util.genartifactdepot.GenArtifact;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JavaInputGenerator {

    private ModelAccess mda = new ModelAccess();

    public void exec() {
        var partObjectNodes = _SpaSectionGenUtil.getModel().getOperCache().getSelectedSectionPart().getObjectNodes();
        mda.getGenVars().getJavaInputClassDefs().clear();
        boolean appendDocumentId = true;
        for(var partNode: partObjectNodes) {
            gen(partNode, appendDocumentId);
            appendDocumentId = false;
        }
    }

    private void gen(MetaNode metaNode, boolean appendDocumentId) {
        GenVars.JavaClassDef jc = new GenVars.JavaClassDef();
        jc.setFullPackage(mda.getGenVars().getJavaInputFullPackage());
        jc.setSimpleClass(metaNode.getFldClassSimpleName() + GenConsta.INPUT_CLASS_SUFFIX);
        jc.setFullClass(jc.getFullPackage() + "." + jc.getSimpleClass());
        jc.setFullFileName(_JavaGenUtils.fullClassName2FullFileName(jc.getFullClass()));
        mda.getGenVars().getJavaInputClassDefs().add(jc);

        String members = "";
        if (appendDocumentId) {
            members += GenConsta.INDENT + "private String documentId" + ";\n";
        }
        for(var f: metaNode.getSubs()) {
            members += GenConsta.INDENT + _JavaGenUtils.getFldDefAsStr(f, GenConsta.INPUT_CLASS_SUFFIX) + ";\n";
        }

        Map<String, Object> params = new HashMap<>();
        params.put("fullPackage", jc.getFullPackage());
        params.put("simpleClass", jc.getSimpleClass());
        params.put("members", StringUtils.removeEnd(members, "\n"));

        VelTempl t = new VelTempl("gen/backend/java/JavaInputGenerator.vm", params);
        String genCode = t.build();

        insertArtifact(jc.getSimpleClass(), jc.getFullFileName(), genCode);
    }

    private void insertArtifact(String simpleClass, String fullFileName, String genCode) {
        GenArtifact ga = new GenArtifact();

        ga.setFrontBack(GenArtifact.EnumFrontBack.BACKEND);
        ga.setLanguage(GenArtifact.EnumLanguage.JAVA);
        ga.setFullPart(GenArtifact.EnumFullPart.FULL_FILE);
        ga.setArtifactDisplayName(simpleClass);
        ga.setSrcFullPath(fullFileName);
        ga.setSrcFile(new File(ga.getSrcFullPath()));
        ga.setGenCode(genCode);

        mda.getArtifactDepot().add(ga);
    }

}
