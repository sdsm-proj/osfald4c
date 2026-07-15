package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.steps;

import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps._StepBase;
import pl.org.opi.util.classdepot.ClassDepot;
import pl.org.opi.util.classdepot.ClassDepot2Impl;
import pl.org.opi.util.classdepot.JarDef;
import pl.org.opi.util.classdepot.SourceTargetDef;

public class Step2010LadujKlasy extends _StepBase {

    @Override
    protected void execCore() throws Exception {
//        // Refleksja
//        //File urlClassesFile1 = new File(_getModel().getPrjRootPath() + "target/classes");
//        File urlClassesFile1 = new File("C:\\ncn\\osf-ncn-nawa-back\\target\\classes");
//        URL url1 = urlClassesFile1.toURI().toURL();
//
//        File urlClassesFile2 = new File("c:\\Users\\abochenek\\.m2\\repository\\pl\\org\\opi\\osf-persistence-spring\\0.8.2-SNAPSHOT\\osf-persistence-spring-0.8.2-SNAPSHOT.jar");
//        // File urlClassesFile2 = new File("c:\\Users\\abochenek\\.m2\\repository\\pl\\org\\opi\\osf-persistence-spring\\0.2.2-SNAPSHOT\\osf-security-spring-0.2.2-SNAPSHOT.jar");
//        URL url2 = urlClassesFile2.toURI().toURL();
//
//        URL[] urls = new URL[]{url1, url2};
//        URLClassLoader classLoader = new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
//
//        Class  klazz1 = classLoader.loadClass("pl.org.opi.nawa.raport.formularz.v1.model.panOsfald.PanOsfald");
//        var sn1 = klazz1.getSimpleName();
//
//        int dbg1 = 1;
//
//
//        //Class  klazz2 = classLoader.loadClass("pl.org.opi.osfsecurity.securitymanager.IPermissionRange");
//        Class  klazz2 = classLoader.loadClass("pl.org.opi.persistence.domain.AbstractDokumentBase");
//        var sn2 = klazz2.getSimpleName();
//
//        int dbg2 = 2;

        //
//        Class  klazzR = classLoader.loadClass("pl.org.opi.nawa.raport.formularz.v1.model.Raport");
//
//        var sc1 = klazzR.getSuperclass();
//
//        // Java parser
//        StaticJavaParser.getParserConfiguration().setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_21);
//
//        CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(new File("c:\\ente-vue\\ncn\\osf-ncn-nawa-back\\src\\main\\java\\pl\\org\\opi\\nawa\\raport\\formularz\\v1\\model\\panOsfald\\PanOsfald.java")));



//        SourceCompiledFolderPair mainPrjFolderPair = new SourceCompiledFolderPair(
//                new File("C:/ncn/osf-ncn-nawa-back/src/main/java/pl/org/opi/nawa/raport/formularz/v1/model"),
//                new File("C:\\ncn\\osf-ncn-nawa-back\\target\\classes\\pl\\org\\opi\\nawa\\raport\\formularz\\v1\\model")
//        );
//        SourceCompiledFolderPair[] secondaryPrjFolderPairs = new SourceCompiledFolderPair[]{};
//        String[] libraryJars = new String[]{
//                "c:\\Users\\abochenek\\.m2\\repository\\pl\\org\\opi\\osf-security-spring\\0.2.2-SNAPSHOT\\osf-security-spring-0.2.2-SNAPSHOT.jar",
//                "c:\\Users\\abochenek\\.m2\\repository\\pl\\org\\opi\\osf-persistence-spring\\0.8.2-SNAPSHOT\\osf-persistence-spring-0.8.2-SNAPSHOT.jar",
//                //"c:\\Users\\abochenek\\.m2\\repository\\pl\\org\\opi\\osf-persistence-spring\\0.2.2-SNAPSHOT\\osf-security-spring-0.2.2-SNAPSHOT.jar"
//        };
//
//        ClassDepot classDepot = new ClassDepotImpl(mainPrjFolderPair, secondaryPrjFolderPairs, libraryJars);
//        classDepot.loadAll();

        SourceTargetDef std = new SourceTargetDef("C:\\ncn\\osf-ncn-nawa-back\\",
                "src/main/java", "target\\classes", new String[] {
                        "pl/org/opi/nawa/raport/formularz/v1/model",
                        "pl/org/opi/nawa/raport/common/model"
        });
        JarDef[] jars = new JarDef[]{
                new JarDef("c:\\Users\\abochenek\\.m2\\repository\\pl\\org\\opi\\osf-persistence-spring\\0.8.2-SNAPSHOT\\osf-persistence-spring-0.8.2-SNAPSHOT.jar"),
                new JarDef("c:\\Users\\abochenek\\.m2\\repository\\pl\\org\\opi\\osf-dictionaries-spring\\0.4.1-SNAPSHOT\\osf-dictionaries-spring-0.4.1-SNAPSHOT.jar"),
                new JarDef("c:\\Users\\abochenek\\.m2\\repository\\pl\\org\\opi\\osf\\osf-validation-spring\\0.3.3-SNAPSHOT\\osf-validation-spring-0.3.3-SNAPSHOT.jar"),
                new JarDef("c:\\Users\\abochenek\\.m2\\repository\\pl\\org\\opi\\osf-signatures-spring\\0.0.6-SNAPSHOT\\osf-signatures-spring-0.0.6-SNAPSHOT.jar")

        };

        ClassDepot cd = new ClassDepot2Impl(std, jars);
        cd.loadAll();

        _getModel().getScenario02Model().setClassDepot(cd);

    }

}
