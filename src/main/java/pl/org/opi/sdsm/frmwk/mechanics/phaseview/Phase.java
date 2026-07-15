package pl.org.opi.sdsm.frmwk.mechanics.phaseview;

import javax.swing.*;

public interface Phase {

    boolean canShow();

    boolean canClose();
    
    void afterCreate();
    
    void afterShow();
    
    JPanel getViewPanel();
    
}
