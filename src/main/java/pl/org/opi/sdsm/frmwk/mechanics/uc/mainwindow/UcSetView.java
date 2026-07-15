package pl.org.opi.sdsm.frmwk.mechanics.uc.mainwindow;

import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.sdsm.frmwk.mechanics.MainWindow;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.Phase;

import javax.swing.*;
import java.awt.*;

public class UcSetView {
    
    public void exec(Phase phaseView) {
        MainWindow mw = AppCtx.getInstance().getMainWindow();
        mw.getPanelMain().removeAll();
//        mw.getPanelMain().setLayout(new BorderLayout());
//        mw.setLayout(new ScrollPaneLayout());
//        mw.getScrollPane1().setViewportView(phaseView.getViewPanel());
        //mw.getPanelMain().setLayout(new BorderLayout());
        //mw.getPanelMain().add(phaseView.getViewPanel());
        JScrollPane sp = new JScrollPane(phaseView.getViewPanel());
        mw.getPanelMain().setLayout(new BorderLayout());
        mw.getPanelMain().add(sp);
        mw.getRootPane().updateUI();
    }
    
}
