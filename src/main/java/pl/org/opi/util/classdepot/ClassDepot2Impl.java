package pl.org.opi.util.classdepot;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.vuespringsection.util.KlazzUtil;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ClassDepot2Impl implements ClassDepot {

    private final ClassLoader classLoader;

    private final SourceTargetDef mainSourceTargetDef;

    private final JarDef[] jarDefs;

    private final List<ClassCuComplex> mainComplexList = new ArrayList<>();

    public ClassDepot2Impl(SourceTargetDef _mainSourceTargetDef, JarDef[] _jarDefs) throws Exception {
        this.mainSourceTargetDef = _mainSourceTargetDef;
        this.jarDefs = _jarDefs;

        List<File> urlAllFiles = new ArrayList<>();
        urlAllFiles.add(mainSourceTargetDef.getFileTargetFullPath());

        for (var jar : jarDefs) {
            urlAllFiles.add(jar.getFileJar());
        }

        List<URL> urlList = new ArrayList<>();
        for (var f : urlAllFiles) {
            urlList.add(f.toURI().toURL());
        }

        URL[] urls = urlList.toArray(new URL[0]);
        classLoader = new URLClassLoader(urls);
    }

    @Override
    public void loadAll() throws Exception {
        fillClasses();
    }

    private void fillClasses() throws ClassNotFoundException {
        // Szukamy plików target-.class we wskazanym podfolderze/pakiecie projektu
        for(File cp: mainSourceTargetDef.getFileClassesSubPath()) {

            var classFiles = FileUtils.listFiles(cp, new String[]{"class"}, true);
            for (File classFile : classFiles) {

                // Szukamy i ładujemy plik .class --------------------------------------------------------------------------

                // Pełna nazwa pliku .class
                String classAbsPath = classFile.getAbsolutePath();

                // Wycinamy tylko listę folderów odpowiadającą pakietom
                String classRelativePath = StringUtils.removeStart(classAbsPath, mainSourceTargetDef.getFileTargetFullPath().getAbsolutePath());

                // Zamieniamy ścieżkę na podtać nazwy pakietu i klasy
                String classFullPath = classRelativePath;
                classFullPath = classFullPath.replace("\\", ".");
                classFullPath = classFullPath.replace("/", ".");
                classFullPath = StringUtils.removeStart(classFullPath, ".");
                classFullPath = StringUtils.removeEnd(classFullPath, ".class");

                // Ładujemy klasę
                Class klazz = null;
                try {
                    klazz = classLoader.loadClass(classFullPath);
                    //System.out.println("OK:  " + classFullPath);
                } catch (Throwable ex) {
                    System.out.println("ERR: " + classFullPath);
                    //ex.printStackTrace();
                }
                if (klazz == null) continue;

                ClassCuComplex cpx = new ClassCuComplex(
                        klazz,
                        classFile,
                        null,
                        null,
                        null
                );
                mainComplexList.add(cpx);

                int dbg1 = 1;
            }
        }
    }

    @Override
    public List<ClassCuComplex> wyszukajDokumenty() {
        List<ClassCuComplex> rslt = new ArrayList<>();
        for (var cux : mainComplexList) {
            if (KlazzUtil.doesExtendClass(cux.getClazz(), "AbstractDokumentBase")) {
                rslt.add(cux);
            }

//            if (KlazzUtil.doesClassImplementIface(cux.getClazz(), "IDokument")) {
//                rslt.add(cux);
//            }
        }
        return rslt;
    }

    @Override
    public boolean existsClass(String canonicalName) {
        try {
            for (var cux : mainComplexList) {
                if (cux.getClazz().getCanonicalName() == null) {
                    continue;
                }
                if (cux.getClazz().getCanonicalName().equals(canonicalName)) {
                    return true;
                }
            }
        } catch(Throwable ex) {
            log.error(ex.getMessage(), ex);
        }
        return false;
    }


}
