/*
 * Created by JFormDesigner on Wed Aug 06 11:22:04 CEST 2025
 */

package pl.org.opi.sdsm.app.frontenddto.stru.generatePhase.ui;

import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.app.frontenddto.oper.generatePhase.*;
import pl.org.opi.sdsm.app.frontenddto.oper.generatePhase.iface.*;
import pl.org.opi.sdsm.app.frontenddto.oper.generatePhase.onlytype.*;
import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;

import javax.swing.*;
import javax.swing.GroupLayout;

public class FdGenerateViewPanel extends JPanel {
    public FdGenerateViewPanel() {
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
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void initComponents2() {
        var selDto = _FrontendDtoGenUtil.getModel().getVars().getSelectedDto();
        if (selDto == null) {
            return;
        }

        switch (selDto.getDtoVariant()) {
            case ONLY_TYPE ->         {
                {
                    StepPanel sp = new StepPanel("ONLY_TYPE_STEP_A", true, true, true, false);
                    sp.createJoin(tabbedPane1);
                    StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new OnlyTypeStepAPrepareOper(sp).exec());
                    StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new OnlyTypeStepADoItOper(sp).exec());
                    sp.getButtonSave().setEnabled(false);
                }
                {
                    StepPanel sp = new StepPanel("ONLY_TYPE_STEP_B", true, true, true, false);
                    sp.createJoin(tabbedPane1);
                    StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new OnlyTypeStepBPrepareOper(sp).exec());
                    StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new OnlyTypeStepBDoItOper(sp).exec());
                    sp.getButtonSave().setEnabled(false);
                }
                {
                    StepPanel sp = new StepPanel("ONLY_TYPE_STEP_C", true, true, true, false);
                    sp.createJoin(tabbedPane1);
                    StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new OnlyTypeStepCPrepareOper(sp).exec());
                    StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new OnlyTypeStepCDoItOper(sp).exec());
                    sp.getButtonSave().setEnabled(false);
                }
            }
            case INTERFACE ->         {
                {
                    StepPanel sp = new StepPanel("INTERFACE_A", true, true, true, false);
                    sp.createJoin(tabbedPane1);
                    StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new InterfaceStepAPrepareOper(sp).exec());
                    StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new InterfaceStepADoItOper(sp).exec());
                    sp.getButtonSave().setEnabled(false);
                }
                {
                    StepPanel sp = new StepPanel("INTERFACE_B", true, true, true, false);
                    sp.createJoin(tabbedPane1);
                    StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new InterfaceStepBPrepareOper(sp).exec());
                    StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new InterfaceStepBDoItOper(sp).exec());
                    sp.getButtonSave().setEnabled(false);
                }
                {
                    StepPanel sp = new StepPanel("INTERFACE_C", true, true, true, false);
                    sp.createJoin(tabbedPane1);
                    StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new InterfaceStepCPrepareOper(sp).exec());
                    StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new InterfaceStepCDoItOper(sp).exec());
                    sp.getButtonSave().setEnabled(false);
                }
            }
            case TYPE_AND_CONST ->         {
                StepPanel sp = new StepPanel("TYPE_AND_CONST", true, true, true, false);
                sp.createJoin(tabbedPane1);
                StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new TypeAndConstPrepareOper(sp).exec());
                StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new TypeAndConstDoItOper(sp).exec());
                sp.getButtonSave().setEnabled(false);
            }
        }
    }
}

// InterfacePrepareOper
// InterfaceDoItOper

// TypeAndConstPrepareOper
// TypeAndConstDoItOper


