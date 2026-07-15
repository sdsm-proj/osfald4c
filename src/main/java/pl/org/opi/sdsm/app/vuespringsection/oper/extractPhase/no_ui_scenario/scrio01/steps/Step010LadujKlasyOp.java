package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.steps;

import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.vuespringsection._VueSpringSectionUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.ProtectionDomain;

@Slf4j
public class Step010LadujKlasyOp extends _StepBase {

    protected void execCore() throws Exception {
        //CompilationUnit cu = StaticJavaParser.parse(Files.newInputStream(Paths.get("D:\\osf-ncn-nawa-back\\src\\main\\java\\pl\\org\\opi\\nawa\\raport\\formularz\\v1\\model\\Raport.java")));

        //JavaParser p = new JavaParser();
        //ParseResult<CompilationUnit> rslt = p.parse(new File("D:\\osf-ncn-nawa-back\\src\\main\\java\\pl\\org\\opi\\nawa\\raport\\formularz\\v1\\model\\Raport.java"));

        StaticJavaParser.getParserConfiguration().setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_21);
        iterateFiles();
    }

    private void iterateFiles() throws Exception {
        String folder = _getModel().getPrjRootPath() + "src/main/java";
        // File dir = new File("D:\\osf-ncn-nawa-back\\src\\main");
        File dir = new File(folder);
        var files = FileUtils.listFiles(dir, new String[]{"java"}, true);

        File urlClassesFile = new File(_getModel().getPrjRootPath() + "target/classes");
        URL url = urlClassesFile.toURI().toURL();
        URL[] urls = new URL[]{url};
        ClassLoader classLoader = new URLClassLoader(urls);

        for (File file : files) {
            CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(file));
            for (var t : cu.getTypes()) {
                _VueSpringSectionUtil.getModel().getParsedProject().add(t, cu);
            }
        }

//        for(var tcu: _VueSpringSectionUtil.getModel().getParsedProject().getTcuMap().values()) {
//            String fullClassName = tcu.getFullTypeName();
//            int dbg1 = 1;
//            Class  cls = classLoader.loadClass(fullClassName);
//            int dbg2 = 1;
//
//            ProtectionDomain pDomain = cls.getProtectionDomain();
//            CodeSource cSource = pDomain.getCodeSource();
//            URL urlfrom = cSource.getLocation();
//
//            String f = urlfrom.getFile();
//
//            System.out.println(urlfrom.getFile());
//
//        }



        //_VueSpringSectionUtil.getModel().getParsedProject().showAll();
//        for(var tcu: _VueSpringSectionUtil.getModel().getParsedProject().getTucMap().values()) {
//            if (tcu.doesExtend("AbstractDokumentBase")) {
//                System.out.println(tcu.getFullTypeName());
//            }
//        }
    }

}
