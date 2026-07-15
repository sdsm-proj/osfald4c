package pl.org.opi.sdsm.frmwk.mechanics.uc.system;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu.UcOpenPrj;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Slf4j
public class UcOpenLastPrj {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() throws Exception {
        String saveFileName = System.getProperty("user.home") + "/.osfald-last-prj.txt";
        if (new File(saveFileName).exists() == false) {
            throw new OsfaldRuntimeException("Save prj file does not exist: " + saveFileName);
        }
        String prjFileName = FileUtils.readFileToString(new File(saveFileName), StandardCharsets.UTF_8);
        if (new File(prjFileName).exists() == false) {
            throw new OsfaldRuntimeException("Prj does not exist: " + prjFileName);
        }
        new UcOpenPrj(prjFileName).exec();
    }

}
