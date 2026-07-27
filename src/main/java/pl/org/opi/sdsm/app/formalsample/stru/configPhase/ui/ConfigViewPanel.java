/*
 * Created by JFormDesigner on Mon Jul 27 11:38:35 CEST 2026
 */

package pl.org.opi.sdsm.app.formalsample.stru.configPhase.ui;

import lombok.Getter;
import pl.org.opi.sdsm.app.formalsample.oper.configPhase.SelectSqlFileOp;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

@Getter
public class ConfigViewPanel extends JPanel {
    public ConfigViewPanel() {
        initComponents();
    }

    private void onBtnWskazPlikSql(ActionEvent e) {
        new SelectSqlFileOp().exec();
        new ConfigViewPanelTransfer(this).model2Ui();
    }

    private void onBtnNextPhase(ActionEvent e) {
        SdsmCtx.getInstance().getCurrGen().showPhase(EnumPhase.EXTRACT);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();
        edNazwaPlikuSql = new JTextField();
        btnWskazPlikSql = new JButton();
        btnNextPhase = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Pe\u0142na nazwa pliku z definicj\u0105 tabel SQL");

        //---- btnWskazPlikSql ----
        btnWskazPlikSql.setText("...");
        btnWskazPlikSql.addActionListener(e -> onBtnWskazPlikSql(e));

        //---- btnNextPhase ----
        btnNextPhase.setText("Kolejna faza >>");
        btnNextPhase.addActionListener(e -> onBtnNextPhase(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(0, 185, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(edNazwaPlikuSql, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnWskazPlikSql))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 272, Short.MAX_VALUE)
                            .addComponent(btnNextPhase)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnWskazPlikSql)
                        .addComponent(edNazwaPlikuSql, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                    .addComponent(btnNextPhase)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JTextField edNazwaPlikuSql;
    private JButton btnWskazPlikSql;
    private JButton btnNextPhase;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
