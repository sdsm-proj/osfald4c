package pl.org.opi.sdsm.app.simplerepo.stru.configPhase.ui;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import lombok.Getter;
import pl.org.opi.sdsm.app.simplerepo.oper.configPhase.VerifyConnUop;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;

@Getter
public class ConfigViewPanel extends javax.swing.JPanel {

    public ConfigViewPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner non-commercial license
    private void initComponents() {
        edDatabaseUrl = new JTextField();
        lbDatabaseUrl = new JLabel();
        lbDatabaseUser = new JLabel();
        edDatabaseUser = new JTextField();
        lbDatabasePass = new JLabel();
        btnCheckConn = new JButton();
        btnSave = new JButton();
        edDatabasePass = new JPasswordField();

        //======== this ========

        //---- lbDatabaseUrl ----
        lbDatabaseUrl.setText("Database url");

        //---- lbDatabaseUser ----
        lbDatabaseUser.setText("User");

        //---- lbDatabasePass ----
        lbDatabasePass.setText("Password");

        //---- btnCheckConn ----
        btnCheckConn.setText("Check connection");
        btnCheckConn.addActionListener(e -> btnCheckConnActionPerformed(e));

        //---- btnSave ----
        btnSave.setText("Save");
        btnSave.addActionListener(e -> btnSaveActionPerformed(e));

        //---- edDatabasePass ----
        edDatabasePass.setText("jPasswordField1");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(edDatabasePass)
                        .addComponent(edDatabaseUrl, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                        .addComponent(edDatabaseUser)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCheckConn)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(lbDatabaseUrl)
                                .addComponent(lbDatabaseUser)
                                .addComponent(lbDatabasePass))
                            .addGap(0, 643, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbDatabaseUrl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edDatabaseUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lbDatabaseUser)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edDatabaseUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lbDatabasePass)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edDatabasePass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCheckConn)
                        .addComponent(btnSave))
                    .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        new ConfigViewPanelTransfer(this).ui2Model();
        SdsmCtx.getInstance().getCurrGen().save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCheckConnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckConnActionPerformed
        new ConfigViewPanelTransfer(this).ui2Model();
        SdsmCtx.getInstance().getCurrGen().save();
        new VerifyConnUop().exec();
    }//GEN-LAST:event_btnCheckConnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JTextField edDatabaseUrl;
    private JLabel lbDatabaseUrl;
    private JLabel lbDatabaseUser;
    private JTextField edDatabaseUser;
    private JLabel lbDatabasePass;
    private JButton btnCheckConn;
    private JButton btnSave;
    private JPasswordField edDatabasePass;
    // End of variables declaration//GEN-END:variables
}
