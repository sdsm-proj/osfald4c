/*
 * Created by JFormDesigner on Mon Jun 16 14:07:17 CEST 2025
 */

package pl.org.opi.sdsm.app.jsde01.stru.extractPhase.ui;

import pl.org.opi.sdsm.app.jsde01.oper.extractPhase.*;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;

import javax.swing.*;
import javax.swing.GroupLayout;

public class ExtractViewPanel extends JPanel {
    public ExtractViewPanel() {
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
                    .addComponent(tabbedPane1)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void initComponents2() {
        {
            StepPanel sp = new StepPanel("patternTable", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new PatternTablePrepareOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new PatternTableDoItOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new PatternTableSaveOper(sp).exec());
        }
        {
            StepPanel sp = new StepPanel("genTable", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new GenTablePrepareOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new GenTableDoItOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new GenTableSaveOper(sp).exec());
        }
    }

}
