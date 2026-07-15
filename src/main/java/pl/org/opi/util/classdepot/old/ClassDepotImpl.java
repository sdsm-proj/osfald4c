package pl.org.opi.util.classdepot.old;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.util.classdepot.ClassCuComplex;
import pl.org.opi.util.classdepot.ClassDepot;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class ClassDepotImpl implements ClassDepot {

    private final SourceCompiledFolderPair mainPrjFolderPair;

    private final SourceCompiledFolderPair[] secondaryPrjFolderPairs;

    private final String[] libraryJars;

    private final List<ClassCuComplex> mainComplexList = new ArrayList<>();

    private final List<ClassCuComplex> secondaryComplexList = new ArrayList<>();

    private final ClassLoader classLoader;

    public ClassDepotImpl(
            SourceCompiledFolderPair mainPrjFolderPair,
            SourceCompiledFolderPair[] secondaryPrjFolderPairs,
            String[] libraryJars
    ) throws MalformedURLException {
        this.mainPrjFolderPair = mainPrjFolderPair;
        if (secondaryPrjFolderPairs != null) {
            this.secondaryPrjFolderPairs = secondaryPrjFolderPairs;
        } else {
            this.secondaryPrjFolderPairs = new SourceCompiledFolderPair[]{};
        }
        if (libraryJars != null) {
            this.libraryJars = libraryJars;
        } else {
            this.libraryJars = new String[]{};
        }

        List<File> urlAllFiles = new ArrayList<>();
        urlAllFiles.add(this.mainPrjFolderPair.getCompiledFolder());
        for(var sec: this.secondaryPrjFolderPairs) {
            urlAllFiles.add(sec.getCompiledFolder());
        }
        for(var jar: this.libraryJars) {
            urlAllFiles.add(new File(jar));
        }

        List<URL> urlList = new ArrayList<>();
        for(var f: urlAllFiles) {
            urlList.add(f.toURI().toURL());
        }

        URL[] urls = urlList.toArray(new URL[0]);
        classLoader = new URLClassLoader(urls);
    }

    @Override
    public void loadAll() throws Exception {
        init();
    }

    @Override
    public List<ClassCuComplex> wyszukajDokumenty() {
        return null;
    }

    @Override
    public boolean existsClass(String canonicalName) {
        return false;
    }

    private void init() throws ClassNotFoundException {
        // Wypełniamy klasy
        fillClasses();
    }

    private void fillClasses() throws ClassNotFoundException {
        fillComplexList(mainPrjFolderPair, mainComplexList);
        for(SourceCompiledFolderPair p: secondaryPrjFolderPairs) {
            fillComplexList(p, secondaryComplexList); // wiele razy do tego samego: secondaryComplexList
        }
    }

    private void fillComplexList(SourceCompiledFolderPair pair, List<ClassCuComplex> complexList) throws ClassNotFoundException {
        var classFiles = FileUtils.listFiles(pair.getCompiledFolder(), new String[]{"class"}, true);
        for (File classFile: classFiles) {    // kolejne pliki *.java z SRC
            String classAbsPath = classFile.getAbsolutePath();
            String classRelativePath = StringUtils.removeStart(classAbsPath, pair.getCompiledFolder().getAbsolutePath());

            String classFullPath = classRelativePath;
            classFullPath = classFullPath.replace("\\", ".");
            classFullPath = classFullPath.replace("/", ".");
            classFullPath = StringUtils.removeStart(classFullPath, ".");
            classFullPath = StringUtils.removeEnd(classFullPath, ".class");

            try {
                classLoader.loadClass(classFullPath);
                //System.out.println(classFullPath);
            } catch(Throwable ex) {
                //System.out.println("ERR: " + classFullPath);
                ex.printStackTrace();
            }

            int dbg1 = 1;
        }


//        var javaFiles = FileUtils.listFiles(pair.getSourceFolder(), new String[]{"java"}, true);
//        for (File javaFile: javaFiles) {    // kolejne pliki *.java z SRC
//            String javaAbsPath = javaFile.getAbsolutePath();
//            String classRelativePath = StringUtils.removeStart(javaAbsPath,pair.getSourceFolder().getAbsolutePath());
//
//
//
//
//            int dbg1 = 1;
//        }

        // szukaj pliku class

        // laduj dla niego klasę

        // szukaj pliku java dla klasy

        // laduj cu

        // szukaj typu w cu

        // dodaj do listy complex
    }

}
