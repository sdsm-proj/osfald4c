package pl.org.opi.sdsm.frmwk.mechanics.prjFactory;

import org.apache.commons.lang3.StringUtils;
import pl.org.opi.util.fileDir.FileChooserUtils;
import pl.org.opi.util.fileDir.FileDirCommon;
import pl.org.opi.util.fileDir.FileDirFindFileOnPathUp;
import pl.org.opi.util.fileDir.FileDirNormalizeName;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.mechanics.gen.Gen;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.GenDef;
import pl.org.opi.sdsm.frmwk.mechanics.registry.PrjTypeRegistry;

public class PrjFactory {

    public static Gen createNewPrj(String prjCode, String fullFileName) {
        fullFileName = FileDirNormalizeName.normalizeFileName(fullFileName);
        
        // Wyszukaj definicji
        GenDef def = PrjTypeRegistry.getInstance().getDefinitionByCode(prjCode);
        if (def == null) {
            throw new OsfaldRuntimeException("Project with code [ " + prjCode + " ] does not exist.");
        }

        // Sprawdzamy, czy plik ma poprawne rozszerzenie
        // Jeśli nie, dodajemy
        String preferredExt = prjCode + ".json";
        fullFileName = FileChooserUtils.addExtensionIfNeeded(fullFileName, preferredExt);
        
        // Sprawdzamy, czy na ścieżce od pliku do root'a znajdziemy plik projektu
        // Jeśli tak, do modelu wpisujemy projectRootPath (absolute/relative path)
        String prjRootDir = FileDirFindFileOnPathUp.findUp(fullFileName, def.getPrjRootShortFileName());
        if (StringUtils.isBlank(prjRootDir)) {
            throw new OsfaldRuntimeException("Project root path not found. Root file: " + def.getPrjRootShortFileName());
        }
        
        // Tworzymy instancję prj
        Gen gen = def.createInstance();
        gen.getModel().setPrjFullFileName(fullFileName);
        gen.getModel().setPrjRootPath(prjRootDir);
        gen.save();
        
        return gen;
    }

    public static Gen openPrj(String fullFileName) {
        fullFileName = FileDirNormalizeName.normalizeFileName(fullFileName);

        // Wyłuskaj prjCode z rozszerzenia pliku
        String ext = FileDirCommon.getFileExtension(fullFileName);
        if (!ext.equals(FileDirCommon.EXT_JSON)) {
            throw new OsfaldRuntimeException("Project file has to have .json extension");
        }
        String codeFileName = StringUtils.removeEnd(fullFileName, FileDirCommon.DOT + FileDirCommon.EXT_JSON);
        String codeExt = FileDirCommon.getFileExtension(codeFileName);
        
        // Wyszukaj w rejestrze def
        GenDef def = PrjTypeRegistry.getInstance().getDefinitionByCode(codeExt);
        if (def == null) {
            throw new OsfaldRuntimeException("Project with code [ " + codeExt + " ] does not exist.");
        }
        
        // sprawdź, czy istnieje root path
        String prjRootDir = FileDirFindFileOnPathUp.findUp(fullFileName, def.getPrjRootShortFileName());
        if (StringUtils.isBlank(prjRootDir)) {
            throw new OsfaldRuntimeException("Project root path not found. Root file: " + def.getPrjRootShortFileName());
        }
        
        // def.openInstance 
        Gen gen = def.openInstance(fullFileName);
        gen.getModel().setPrjFullFileName(fullFileName);
        gen.getModel().setPrjRootPath(prjRootDir);
        
        return gen;
    }
    
}
