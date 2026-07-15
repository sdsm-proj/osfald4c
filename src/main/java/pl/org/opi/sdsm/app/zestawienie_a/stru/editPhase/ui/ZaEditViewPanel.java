/*
 * Created by JFormDesigner on Sat Sep 13 20:35:35 CEST 2025
 */

package pl.org.opi.sdsm.app.zestawienie_a.stru.editPhase.ui;

import lombok.Getter;
import pl.org.opi.sdsm.app.zestawienie_a.oper.editPhase.ProposeOper;
import pl.org.opi.sdsm.app.zestawienie_a.oper.editPhase.SaveOper;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.uc.gen.UcPhaseSelect;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author abochenek
 */
@Getter
public class ZaEditViewPanel extends JPanel {
    public ZaEditViewPanel() {
        initComponents();
    }

    private void btnSave(ActionEvent e) {
        new SaveOper(this).exec();
    }

    private void btnPropose(ActionEvent e) {
        new ProposeOper(this).exec();
    }

    private void btnGotoGenerate(ActionEvent e) {
        new SaveOper(this).exec();
        new UcPhaseSelect().exec(EnumPhase.GENERATE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();
        edAngularComponentPath = new JTextField();
        label2 = new JLabel();
        edAngularComponentFileName = new JTextField();
        label3 = new JLabel();
        edComponentClassName = new JTextField();
        label4 = new JLabel();
        edSelector = new JTextField();
        btnSave = new JButton();
        btnPropose = new JButton();
        label5 = new JLabel();
        labelTs = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        labelHtml = new JLabel();
        labelCss = new JLabel();
        button1 = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Angular component path");

        //---- label2 ----
        label2.setText("Angular component short name");

        //---- label3 ----
        label3.setText("Component class name");

        //---- label4 ----
        label4.setText("Selector");

        //---- btnSave ----
        btnSave.setText("Save");
        btnSave.addActionListener(e -> btnSave(e));

        //---- btnPropose ----
        btnPropose.setText("Propose");
        btnPropose.addActionListener(e -> btnPropose(e));

        //---- label5 ----
        label5.setText("ts:");

        //---- labelTs ----
        labelTs.setText("   ");

        //---- label7 ----
        label7.setText("html:");

        //---- label8 ----
        label8.setText("css:");

        //---- labelHtml ----
        labelHtml.setText("   ");

        //---- labelCss ----
        labelCss.setText("   ");

        //---- button1 ----
        button1.setText("Generate >>");
        button1.addActionListener(e -> btnGotoGenerate(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnPropose)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 517, Short.MAX_VALUE)
                            .addComponent(btnSave))
                        .addComponent(edAngularComponentPath, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                        .addComponent(edAngularComponentFileName, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label8)
                                .addComponent(label7)
                                .addComponent(label5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(labelTs, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                                .addComponent(labelCss, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                                .addComponent(labelHtml, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)))
                        .addComponent(edComponentClassName, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2)
                                .addComponent(label3)
                                .addComponent(label4))
                            .addGap(0, 503, Short.MAX_VALUE))
                        .addComponent(edSelector, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 595, Short.MAX_VALUE)
                            .addComponent(button1)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnPropose))
                    .addGap(7, 7, 7)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edAngularComponentPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edAngularComponentFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(labelTs))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelHtml)
                        .addComponent(label7))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8)
                        .addComponent(labelCss))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edComponentClassName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JTextField edAngularComponentPath;
    private JLabel label2;
    private JTextField edAngularComponentFileName;
    private JLabel label3;
    private JTextField edComponentClassName;
    private JLabel label4;
    private JTextField edSelector;
    private JButton btnSave;
    private JButton btnPropose;
    private JLabel label5;
    private JLabel labelTs;
    private JLabel label7;
    private JLabel label8;
    private JLabel labelHtml;
    private JLabel labelCss;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


}
