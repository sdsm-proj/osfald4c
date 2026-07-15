package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.util.genartifactdepot.GenArtifact;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.optool.MetaNode;
import pl.org.opi.sdsm.frmwk.util.velocity.VelTempl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JavaServiceImplGenerator {

    private ModelAccess mda = new ModelAccess();

    public void exec() {
        gen(_SpaSectionGenUtil.getModel().getOperCache().getSelectedSectionPart());
    }

    private void gen(MetaNode metaNode) {
        Map<String, Object> params = new HashMap<>();
        params.put("fullPackage", mda.getGenVars().getJavaServiceImplClassDef().getFullPackage());
        params.put("simpleClass", mda.getGenVars().getJavaServiceImplClassDef().getSimpleClass());
        params.put("simpleClassIface", mda.getGenVars().getJavaServiceIfaceClassDef().getSimpleClass());
        params.put("domainFullClass", mda.getEditSectionLevel().getDomainFullClass());
        params.put("domainSimpleClass", mda.getEditSectionLevel().getDomainSimpleClass());
        params.put("domainSimpleClassLower", mda.getEditSectionLevel().getDomainSimpleClassLower());
        params.put("serviceOperationNameLower", mda.getEditSectionLevel().getServiceOperationNameLower());

        VelTempl t = new VelTempl("gen/backend/java/JavaServiceImplGenerator.vm", params);
        String genCode = t.build();

        insertArtifact(genCode);
    }

    private void insertArtifact(String genCode) {
        GenArtifact ga = new GenArtifact();

        ga.setFrontBack(GenArtifact.EnumFrontBack.BACKEND);
        ga.setLanguage(GenArtifact.EnumLanguage.JAVA);
        ga.setFullPart(GenArtifact.EnumFullPart.FULL_FILE);
        ga.setArtifactDisplayName(mda.getGenVars().getJavaServiceImplClassDef().getSimpleClass());
        ga.setSrcFullPath(mda.getGenVars().getJavaServiceImplClassDef().getFullFileName());
        ga.setSrcFile(new File(ga.getSrcFullPath()));
        ga.setGenCode(genCode);

        mda.getArtifactDepot().add(ga);
    }

}
