/*
 * Created by JFormDesigner on Mon Jun 16 14:07:53 CEST 2025
 */

package pl.org.opi.sdsm.app.jsde01.stru.generatePhase.ui;

import javax.swing.*;
import javax.swing.GroupLayout;

import pl.org.opi.sdsm.app.jsde01.oper.generatePhase.app.*;
import pl.org.opi.sdsm.app.jsde01.oper.generatePhase.infra.*;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;

public class GenerateViewPanel extends JPanel {
    public GenerateViewPanel() {
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
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
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
            StepPanel sp = new StepPanel("infraEntity", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new InfraEntityPrepareOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new InfraEntityDoItOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new InfraEntitySaveOper(sp).exec());
        }
        {
            StepPanel sp = new StepPanel("appEntityId", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new AppEntityIdPrepareOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new AppEntityIdDoItOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new AppEntityIdSaveOper(sp).exec());
        }
        {
            StepPanel sp = new StepPanel("appDtoDto", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new AppDtoDtoPrepare(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new AppDtoDtoDoIt(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new AppDtoDtoSave(sp).exec());
        }

        {
            StepPanel sp = new StepPanel("infraAddVo", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new InfraAddVoPrepare(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new InfraAddVoDoIt(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new InfraAddVoSave(sp).exec());
        }
        {
            StepPanel sp = new StepPanel("infraRepo", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new InfraRepoPrepare(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new InfraRepoDoIt(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new InfraRepoSave(sp).exec());
        }
    }

}
