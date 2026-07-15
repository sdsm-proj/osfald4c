package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.util.genartifactdepot.GenArtifact;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JavaOutputMapperGenerator {

    private ModelAccess mda = new ModelAccess();

    public void exec() {
        gen(_SpaSectionGenUtil.getModel().getOperCache().getSelectedSectionPart());
    }

    private void gen(MetaNode metaNode) {
        Map<String, Object> params = new HashMap<>();
        params.put("fullPackage", mda.getGenVars().getJavaOutputMapper().getFullPackage());
        params.put("simpleClass", mda.getGenVars().getJavaOutputMapper().getSimpleClass());
        params.put("javaOutputFullClass", mda.getGenVars().getJavaOutputClassDefs().get(0).getFullClass());
        params.put("javaOutputSimpleClass", mda.getGenVars().getJavaOutputClassDefs().get(0).getSimpleClass());
        params.put("domainFullClass", mda.getEditSectionLevel().getDomainFullClass());
        params.put("domainSimpleClass", mda.getEditSectionLevel().getDomainSimpleClass());
        VelTempl t = new VelTempl("gen/backend/java/JavaOutputMapperGenerator.vm", params);
        String genCode = t.build();
        insertArtifact(genCode);
    }

    private void insertArtifact(String genCode) {
        GenArtifact ga = new GenArtifact();
        ga.setFrontBack(GenArtifact.EnumFrontBack.BACKEND);
        ga.setLanguage(GenArtifact.EnumLanguage.JAVA);
        ga.setFullPart(GenArtifact.EnumFullPart.FULL_FILE);
        ga.setArtifactDisplayName(mda.getGenVars().getJavaOutputMapper().getSimpleClass());
        ga.setSrcFullPath(mda.getGenVars().getJavaOutputMapper().getFullFileName());
        ga.setSrcFile(new File(ga.getSrcFullPath()));
        ga.setGenCode(genCode);
        mda.getArtifactDepot().add(ga);
    }

}
