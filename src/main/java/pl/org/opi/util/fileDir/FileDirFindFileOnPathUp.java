package pl.org.opi.util.fileDir;

import java.io.File;

public class FileDirFindFileOnPathUp {

    public static String findUp(String aPath, String aShortFileName) {
        String rsltPath = null;
        String startPath = FileDirNormalizeName.normalizePathName(aPath);
        aShortFileName = aShortFileName.trim();

        File f = new File(startPath);
        while (1 == 1) {
            if (f.isDirectory()) {
                String ap = f.getAbsolutePath();
                String normAp = FileDirNormalizeName.normalizePathName(ap);
                String fileName = normAp + aShortFileName;
                File findFile = new File(fileName);
                if (findFile.exists()) {
                    rsltPath = normAp;
                    break;
                }
            }

            f = f.getParentFile();
            if (f == null) {
                break;
            }

//            String x = f.getAbsolutePath();
//            System.out.println(x);
//            int dbg1 = 1;
        }

        return rsltPath;
    }

}
