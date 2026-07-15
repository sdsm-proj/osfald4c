package pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase;

import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.app.vuespringsection._VueSpringSectionUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Slf4j
public class TestJavaParserOp {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() throws Exception {
        //CompilationUnit cu = StaticJavaParser.parse(Files.newInputStream(Paths.get("D:\\osf-ncn-nawa-back\\src\\main\\java\\pl\\org\\opi\\nawa\\raport\\formularz\\v1\\model\\Raport.java")));

        //JavaParser p = new JavaParser();
        //ParseResult<CompilationUnit> rslt = p.parse(new File("D:\\osf-ncn-nawa-back\\src\\main\\java\\pl\\org\\opi\\nawa\\raport\\formularz\\v1\\model\\Raport.java"));

        StaticJavaParser.getParserConfiguration().setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_21);
        iterateFiles();
    }

    private void iterateFiles() throws FileNotFoundException {
        File dir = new File("D:\\osf-ncn-nawa-back\\src\\main");
        var files = FileUtils.listFiles(dir, new String[]{"java"}, true);

        for(File file: files) {
            CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(file));
            for(var t: cu.getTypes()) {
                _VueSpringSectionUtil.getModel().getParsedProject().add(t, cu);
            }
        }

        //_VueSpringSectionUtil.getModel().getParsedProject().showAll();

        for(var tcu: _VueSpringSectionUtil.getModel().getParsedProject().getTcuMap().values()) {
            if (tcu.doesExtend("AbstractDokumentBase")) {
                System.out.println(tcu.getFullTypeName());
            }
        }

    }

}
