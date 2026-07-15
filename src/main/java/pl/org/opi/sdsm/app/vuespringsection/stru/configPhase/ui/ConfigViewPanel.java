/*
 * Created by JFormDesigner on Tue Oct 01 21:34:00 CEST 2024
 */

package pl.org.opi.sdsm.app.vuespringsection.stru.configPhase.ui;

import javax.swing.*;
import javax.swing.GroupLayout;

import static javax.swing.GroupLayout.*;

/**
 * @author aboch
 */
public class ConfigViewPanel extends JPanel {
    public ConfigViewPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========

        //---- label1 ----
        label1.setText("text");

        //---- label2 ----
        label2.setText("text");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addContainerGap(484, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(484, Short.MAX_VALUE)
                    .addComponent(label2)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 616, Short.MAX_VALUE)
                    .addComponent(label2)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
