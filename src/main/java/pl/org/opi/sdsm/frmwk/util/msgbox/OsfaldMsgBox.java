package pl.org.opi.sdsm.frmwk.util.msgbox;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;

import javax.swing.*;

@Slf4j
public class OsfaldMsgBox {

    static public void error(String msg) {
        JOptionPane.showMessageDialog(AppCtx.getInstance().getMainWindow(), msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    static public void error(Throwable ex) {
        String msg = ex.getClass().getSimpleName();
        if (StringUtils.isNotBlank(ex.getMessage())) {
            msg += "\n\n" + ex.getMessage();
        }
        JOptionPane.showMessageDialog(AppCtx.getInstance().getMainWindow(), msg, "Error", JOptionPane.ERROR_MESSAGE);
        log.error(ex.getMessage(), ex);
    }
    
    static public void warn(String msg) {
        JOptionPane.showMessageDialog(AppCtx.getInstance().getMainWindow(), msg, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    static public void info(String msg) {
        JOptionPane.showMessageDialog(AppCtx.getInstance().getMainWindow(), msg, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    static public void tip(String msg) {
        JOptionPane.showMessageDialog(AppCtx.getInstance().getMainWindow(), msg, "Tip", JOptionPane.PLAIN_MESSAGE);
    }
    
    static public boolean yesNo(String msg) {
        int dialogResult = JOptionPane.showConfirmDialog(AppCtx.getInstance().getMainWindow(), msg, "Question", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }
    
}
