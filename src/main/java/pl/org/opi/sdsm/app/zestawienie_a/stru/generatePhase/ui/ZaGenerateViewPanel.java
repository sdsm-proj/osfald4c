/*
 * Created by JFormDesigner on Sat Sep 13 20:35:56 CEST 2025
 */

package pl.org.opi.sdsm.app.zestawienie_a.stru.generatePhase.ui;

import pl.org.opi.sdsm.frmwk.steppanel.StepPanel;
import pl.org.opi.sdsm.app.zestawienie_a.oper.generatePhase.*;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author abochenek
 */
public class ZaGenerateViewPanel extends JPanel {
    public ZaGenerateViewPanel() {
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
                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void initComponents2() {
        {
            StepPanel sp = new StepPanel("html", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new HtmlPrepareOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new HtmlDoItOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new HtmlSaveOper(sp).exec());
        }
        {
            StepPanel sp = new StepPanel("ts", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new TsPrepareOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new TsDoItOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new TsSaveOper(sp).exec());
        }
        {
            StepPanel sp = new StepPanel("css", true, true, true, false);
            sp.createJoin(tabbedPane1);
            StepPanel.connectAsyncOper(sp.getButtonPrepare(), sp, () -> new CssPrepareOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonDoIt(), sp, () -> new CssDoItOper(sp).exec());
            StepPanel.connectAsyncOper(sp.getButtonSave(), sp, () -> new CssSaveOper(sp).exec());
        }
    }

}
