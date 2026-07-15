package pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.graphql2.InputGraphQLGenerator;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.graphql2.MutationGraphQLGenerator;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.graphql2.OutputGraphQLGenerator;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.backend.java.*;

public class GenerateBackendOper {

    private ModelAccess mda = new ModelAccess();

    public void exec() {
        execCore();
    }

    private void execCore() {
        mda.getArtifactDepot().getArtifacts().clear();

        new _CalcGenVars().exec();
        new JavaInputGenerator().exec();
        new JavaOutputGenerator().exec();
        new JavaServiceIfaceGenerator().exec();
        new JavaServiceImplGenerator().exec();
        new JavaControllerGenerator().exec();
        new JavaInputMapperGenerator().exec();
        new JavaOutputMapperGenerator().exec();
        new InputGraphQLGenerator().exec();
        new OutputGraphQLGenerator().exec();
        new MutationGraphQLGenerator().exec();

        new CountLinesOfCodeOper().exec();

        _SpaSectionGenUtil.getGen().save();
    }

}
