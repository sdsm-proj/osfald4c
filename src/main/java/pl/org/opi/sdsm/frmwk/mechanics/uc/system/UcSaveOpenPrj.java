package pl.org.opi.sdsm.frmwk.mechanics.uc.system;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu.LastPrjList;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Slf4j
public class UcSaveOpenPrj {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    private void execCore() throws Exception {
        String saveFileName = System.getProperty("user.home") + "/.osfald-last-prj.txt";
        String prjFileName = SdsmCtx.getInstance().getCurrGen().getModel().getPrjFullFileName();
        FileUtils.write(new File(saveFileName), prjFileName, StandardCharsets.UTF_8);

        LastPrjList lastPrjList = new LastPrjList();
        lastPrjList.afterPrjOpened(prjFileName);

    }


}
