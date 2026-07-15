/*
 * Created by JFormDesigner on Sat Sep 13 20:35:17 CEST 2025
 */

package pl.org.opi.sdsm.app.zestawienie_a.stru.configPhase.ui;

import lombok.Getter;
import pl.org.opi.sdsm.app.zestawienie_a.oper.configPhase.SaveOper;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.uc.gen.UcPhaseSelect;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author abochenek
 */
@Getter
public class ZaConfigViewPanel extends JPanel {
    public ZaConfigViewPanel() {
        initComponents();
    }

    private void btnSave(ActionEvent e) {
        new SaveOper(this).exec();
    }

    private void btnNext(ActionEvent e) {
        new SaveOper(this).exec();
        new UcPhaseSelect().exec(EnumPhase.EXTRACT);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        btnSave = new JButton();
        label1 = new JLabel();
        edPrjFrontFullPath = new JTextField();
        label2 = new JLabel();
        edPrjContractFullPath = new JTextField();
        label3 = new JLabel();
        edPrjBackendFullPath = new JTextField();
        label4 = new JLabel();
        edPrjBackendGenFullPath = new JTextField();
        btnNext = new JButton();

        //======== this ========

        //---- btnSave ----
        btnSave.setText("Save");
        btnSave.addActionListener(e -> btnSave(e));

        //---- label1 ----
        label1.setText("prjFrontFullPath");

        //---- label2 ----
        label2.setText("prjContractFullPath");

        //---- label3 ----
        label3.setText("prjBackendFullPath");

        //---- label4 ----
        label4.setText("prjBackendGenFullPath");

        //---- btnNext ----
        btnNext.setText("Extract >>");
        btnNext.addActionListener(e -> btnNext(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(edPrjFrontFullPath, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                        .addComponent(edPrjContractFullPath, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                        .addComponent(edPrjBackendFullPath, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(label2)
                                .addComponent(label3)
                                .addComponent(label4))
                            .addGap(0, 540, Short.MAX_VALUE))
                        .addComponent(edPrjBackendGenFullPath, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 574, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(btnSave, GroupLayout.Alignment.TRAILING)
                                .addComponent(btnNext, GroupLayout.Alignment.TRAILING))))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnSave)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edPrjFrontFullPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edPrjContractFullPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edPrjBackendFullPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edPrjBackendGenFullPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                    .addComponent(btnNext)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JButton btnSave;
    private JLabel label1;
    private JTextField edPrjFrontFullPath;
    private JLabel label2;
    private JTextField edPrjContractFullPath;
    private JLabel label3;
    private JTextField edPrjBackendFullPath;
    private JLabel label4;
    private JTextField edPrjBackendGenFullPath;
    private JButton btnNext;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
