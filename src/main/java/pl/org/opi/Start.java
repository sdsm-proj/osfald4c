package pl.org.opi;

import com.formdev.flatlaf.FlatLightLaf;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.sdsm.frmwk.mechanics.MainWindow;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.uc.gen.UcPhaseSelect;
import pl.org.opi.sdsm.frmwk.mechanics.uc.system.UcOpenLastPrj;
import pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu.UcAppendLastOpenedProjects;
import pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu.UcNewPrj;
import pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu.UcOpenPrj;

import javax.swing.*;

@Slf4j
public class Start {
    public static void main(String[] args) {
        log.info("Osfald starting...");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            log.error(ex.getMessage(), ex);
        }
        AppCtx.init(new MainWindow());
        AppCtx.getInstance().getMainWindow().setVisible(true);

        new UcAppendLastOpenedProjects().exec();
        new UcOpenLastPrj().exec();
        log.info("Osfald started");
    }
}
