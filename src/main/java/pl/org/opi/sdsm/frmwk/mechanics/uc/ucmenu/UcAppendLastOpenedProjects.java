package pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu;

import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Slf4j
public class UcAppendLastOpenedProjects {

    public void exec() {
        try {
            execCore();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            OsfaldMsgBox.error(ex);
        }
    }

    private void execCore() {
        LastPrjList lastPrjList = new LastPrjList();
        List<String> fileNames = lastPrjList.lastFileList();
        if (!fileNames.isEmpty()) {
            var menuFile = AppCtx.getInstance().getMainWindow().getMenuFile();
            menuFile.addSeparator();
            for(var fileName: fileNames) {
                var mi = menuFile.add(new JMenuItem(fileName));
                mi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new UcOpenPrj(fileName).exec();
                    }
                });
            }
        }
    }

}
