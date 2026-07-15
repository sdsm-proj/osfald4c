package pl.org.opi.commons.fileDir;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

import static pl.org.opi.commons.fileDir.FileDirCommon.BACKSLASH;
import static pl.org.opi.commons.fileDir.FileDirCommon.SLASH;

public class FileDirNormalizeName {

    public static String normalizePathName(String aPath) {
        String inputPath = aPath.trim();
        if (StringUtils.isBlank(inputPath)) {
            return "";
        }

        String path = FilenameUtils.getPathNoEndSeparator(inputPath);
        String prefix = FilenameUtils.getPrefix(inputPath);
        String lastName = FilenameUtils.getName(inputPath);

        String fullPath = "";
        if (StringUtils.isNotBlank(prefix)) {
            fullPath += prefix;
        }
        if (StringUtils.isNotBlank(path)) {
            fullPath += path;
        }
        if (StringUtils.isNotBlank(lastName)) {
            if (StringUtils.isNotBlank(fullPath)) {
                if (fullPath.endsWith(SLASH)) {
                    fullPath += lastName;
                } else {
                    fullPath += SLASH + lastName;
                }
            } else {
                fullPath += lastName;
            }
        }

        fullPath = StringUtils.replaceChars(fullPath, BACKSLASH, SLASH);
        if (!fullPath.endsWith(SLASH)) {
            fullPath += SLASH;
        }
        if (fullPath.startsWith(SLASH)) {
            fullPath = StringUtils.removeStart(fullPath, SLASH);
        }
        if (fullPath.equals(SLASH)) {
            fullPath = "";
        }

        return fullPath;
    }

    public static String normalizeFileName(String aFullFileName) {
        String fileName = normalizePathName(aFullFileName);
        fileName = StringUtils.removeEnd(fileName, SLASH);
        return fileName;
    }

    public static String removeLastElemIfExistingFile(String aPath) {
        File f = new File(aPath);
        if (f.exists()) {
            if (f.isFile()) {
                String path = FilenameUtils.getPathNoEndSeparator(aPath);
                String prefix = FilenameUtils.getPrefix(aPath);
                String lastName = FilenameUtils.getName(aPath);
                String fullPath = prefix + path;
                return fullPath;
            }
        }
        return aPath;
    }

}
