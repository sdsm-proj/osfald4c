package pl.org.opi.sdsm.app.simplerepo.stru.configPhase.ui;

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
    private void initComponents() {

        edDatabaseUrl = new javax.swing.JTextField();
        lbDatabaseUrl = new javax.swing.JLabel();
        lbDatabaseUser = new javax.swing.JLabel();
        edDatabaseUser = new javax.swing.JTextField();
        lbDatabasePass = new javax.swing.JLabel();
        btnCheckConn = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        edDatabasePass = new javax.swing.JPasswordField();

        lbDatabaseUrl.setText("Database url");

        lbDatabaseUser.setText("User");

        lbDatabasePass.setText("Password");

        btnCheckConn.setText("Check connection");
        btnCheckConn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckConnActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        edDatabasePass.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edDatabasePass)
                    .addComponent(edDatabaseUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                    .addComponent(edDatabaseUser)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCheckConn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDatabaseUrl)
                            .addComponent(lbDatabaseUser)
                            .addComponent(lbDatabasePass))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDatabaseUrl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edDatabaseUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDatabaseUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edDatabaseUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDatabasePass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edDatabasePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckConn)
                    .addComponent(btnSave))
                .addContainerGap(154, Short.MAX_VALUE))
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
    private javax.swing.JButton btnCheckConn;
    private javax.swing.JButton btnSave;
    private javax.swing.JPasswordField edDatabasePass;
    private javax.swing.JTextField edDatabaseUrl;
    private javax.swing.JTextField edDatabaseUser;
    private javax.swing.JLabel lbDatabasePass;
    private javax.swing.JLabel lbDatabaseUrl;
    private javax.swing.JLabel lbDatabaseUser;
    // End of variables declaration//GEN-END:variables
}
