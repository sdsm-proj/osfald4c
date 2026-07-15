package pl.org.opi.sdsm.app.jsde01.stru.configPhase.ui;

import lombok.Getter;
import pl.org.opi.sdsm.app.jsde01.oper.configPhase.BasicConfigPanelPrepareOper;
import pl.org.opi.sdsm.app.jsde01.oper.configPhase.BasicConfigPanelSaveOper;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;

import javax.swing.*;
import javax.swing.GroupLayout;

@Getter
public class ConfigViewPanel extends JPanel {
    public ConfigViewPanel() {
        initComponents();
        initComponents2();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();

        //======== this ========

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void initComponents2() {
        StepPanel sp1 = new StepPanel("basicConfig", true, false, true, false);
        sp1.createJoin(tabbedPane1);
        StepPanel.connectAsyncOper(sp1.getButtonPrepare(), sp1, () -> new BasicConfigPanelPrepareOper(sp1).exec());
        StepPanel.connectAsyncOper(sp1.getButtonSave(), sp1, () -> new BasicConfigPanelSaveOper(sp1).exec());
    }

}
