/*
 * Created by JFormDesigner on Mon Jul 27 11:48:14 CEST 2026
 */

package pl.org.opi.sdsm.app.formalsample.stru.editPhase.ui;

import lombok.Getter;
import pl.org.opi.sdsm.app.formalsample.oper.editPhase.Confirm;
import pl.org.opi.sdsm.app.formalsample.oper.editPhase.LoadRefresh;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

@Getter
public class EditViewPanel extends JPanel {
    public EditViewPanel() {
        initComponents();
    }

    private void onBtnLoadRefresh(ActionEvent e) {
        new LoadRefresh().exec(this);
    }

    private void onBtnConfirm(ActionEvent e) {
        new Confirm().exec(this);
    }

    private void onBtnNextPhase(ActionEvent e) {
        SdsmCtx.getInstance().getCurrGen().showPhase(EnumPhase.GENERATE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        btnNextPhase = new JButton();
        label2 = new JLabel();
        taFieldsEdited = new JTextArea();
        btnLoadRefresh = new JButton();
        btnConfirm = new JButton();

        //======== this ========

        //---- btnNextPhase ----
        btnNextPhase.setText("Kolejna faza >>");
        btnNextPhase.addActionListener(e -> onBtnNextPhase(e));

        //---- label2 ----
        label2.setText("Ostateczna lista nazw i typ\u00f3w");

        //---- btnLoadRefresh ----
        btnLoadRefresh.setText("Za\u0142aduj/od\u015bwie\u017c list\u0119 pobran\u0105");
        btnLoadRefresh.addActionListener(e -> onBtnLoadRefresh(e));

        //---- btnConfirm ----
        btnConfirm.setText("Zaakceptuj list\u0119 p\u00f3l");
        btnConfirm.addActionListener(e -> onBtnConfirm(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnLoadRefresh)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 250, Short.MAX_VALUE)
                                    .addComponent(btnNextPhase))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnConfirm)
                                    .addGap(0, 230, Short.MAX_VALUE))))
                        .addComponent(taFieldsEdited, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(taFieldsEdited, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLoadRefresh)
                        .addComponent(btnConfirm))
                    .addGap(4, 4, 4)
                    .addComponent(btnNextPhase)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JButton btnNextPhase;
    private JLabel label2;
    private JTextArea taFieldsEdited;
    private JButton btnLoadRefresh;
    private JButton btnConfirm;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
