package pl.org.opi.sdsm.app.spasection.oper.generatePhase;

import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.stru.generatePhase.ui.GenerateViewPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class InitOper {

    private final GenerateViewPanel viewPanel;

    public InitOper(GenerateViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    public void exec() {
        _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot().getArtifacts().clear();

        JTable t = viewPanel.getTableArtifacts();
        t.setModel(_SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot());
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        t.setRowSelectionAllowed(false);
        t.setCellSelectionEnabled(true);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                if (t.getSelectionModel().getMinSelectionIndex() >= 0) {
                    System.out.println("Zaznaczone: " + t.getSelectionModel().getMinSelectionIndex());
                    new ShowArtifactOper(viewPanel).exec();
                } else {
                    System.out.println("pusta tabela, nic nie zaznaczone");
                    new ClearArtifactOper(viewPanel).exec();
                }
            }
        });
        t.getColumnModel().getColumn(2).setPreferredWidth(250);
        t.getColumnModel().getColumn(4).setPreferredWidth(250);
    }

}
