/*
 * Created by JFormDesigner on Sat Sep 13 20:35:46 CEST 2025
 */

package pl.org.opi.sdsm.app.zestawienie_a.stru.extractPhase.ui;

import lombok.Getter;
import pl.org.opi.sdsm.app.zestawienie_a._ZestawienieAUtil;
import pl.org.opi.sdsm.app.zestawienie_a.oper.extractPhase.FindColumnsOper;
import pl.org.opi.sdsm.app.zestawienie_a.oper.extractPhase.FindEndpointsOper;
import pl.org.opi.sdsm.app.zestawienie_a.oper.extractPhase.GotoEditOper;
import pl.org.opi.sdsm.app.zestawienie_a.oper.extractPhase.RelaodOper;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.uc.gen.UcPhaseSelect;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author abochenek
 */
@Getter
public class ZaExtractViewPanel extends JPanel {
    public ZaExtractViewPanel() {
        initComponents();
        initComponents2();
    }

    private void initComponents2() {
        comboModel.setModel(new DefaultComboBoxModel());
        comboCtrl.setModel(new DefaultComboBoxModel());
        comboEndpoints.setModel(new DefaultComboBoxModel());
//        comboModel.addItem(new ComboItem(""));
//        comboModel.addItem(new ComboItem("b"));
//        comboModel.addItem(new ComboItem("c"));
//        //comboModel.removeAllItems();
    }

    private void onReload(ActionEvent e) {
        new RelaodOper(this).exec();
    }

    private void onNext(ActionEvent e) {
        {
            Object comboItem = comboModel.getSelectedItem();
            if (comboItem == null) {
                OsfaldMsgBox.error("Choose model");
                return;
            }
            if (((ComboItem)comboItem).getJavaFile() == null) {
                OsfaldMsgBox.error("Choose model");
                return;
            }
        }
        {
            Object comboItem = comboCtrl.getSelectedItem();
            if (comboItem == null) {
                OsfaldMsgBox.error("Choose controller");
                return;
            }
            if (((ComboItem)comboItem).getJavaFile() == null) {
                OsfaldMsgBox.error("Choose controller");
                return;
            }
        }

        new GotoEditOper(this).exec();
        _ZestawienieAUtil.getGen().save();
        new UcPhaseSelect().exec(EnumPhase.EDIT);
    }

    private void button3(ActionEvent e) {
        new FindEndpointsOper(this).exec();
    }

    private void button4(ActionEvent e) {
        new FindColumnsOper(this).exec();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();
        label2 = new JLabel();
        comboModel = new JComboBox();
        comboCtrl = new JComboBox();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        comboEndpoints = new JComboBox();
        button4 = new JButton();
        scrollPane1 = new JScrollPane();
        taColumns = new JTextArea();

        //======== this ========

        //---- label1 ----
        label1.setText("Choose model");

        //---- label2 ----
        label2.setText("Choose API");

        //---- button1 ----
        button1.setText("Reload");
        button1.addActionListener(e -> onReload(e));

        //---- button2 ----
        button2.setText("Edit >>");
        button2.addActionListener(e -> onNext(e));

        //---- button3 ----
        button3.setText("Find endpoints");
        button3.addActionListener(e -> button3(e));

        //---- button4 ----
        button4.setText("Find columns");
        button4.addActionListener(e -> button4(e));

        //======== scrollPane1 ========
        {

            //---- taColumns ----
            taColumns.setEditable(false);
            scrollPane1.setViewportView(taColumns);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                        .addComponent(comboEndpoints, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                        .addComponent(comboModel, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                        .addComponent(comboCtrl, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 670, Short.MAX_VALUE)
                            .addComponent(button2))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(button1)
                                .addComponent(label2)
                                .addComponent(button3)
                                .addComponent(button4))
                            .addGap(0, 635, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(button1)
                    .addGap(18, 18, 18)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboCtrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboEndpoints, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JLabel label2;
    private JComboBox comboModel;
    private JComboBox comboCtrl;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JComboBox comboEndpoints;
    private JButton button4;
    private JScrollPane scrollPane1;
    private JTextArea taColumns;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
