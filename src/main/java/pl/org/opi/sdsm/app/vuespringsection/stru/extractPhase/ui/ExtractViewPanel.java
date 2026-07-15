/*
 * Created by JFormDesigner on Tue Oct 01 21:38:55 CEST 2024
 */

package pl.org.opi.sdsm.app.vuespringsection.stru.extractPhase.ui;

import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.TestJavaParserOp;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio01.Scenario01;
import pl.org.opi.sdsm.app.vuespringsection.oper.extractPhase.no_ui_scenario.scrio02.Scenario02;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class ExtractViewPanel extends JPanel {
    public ExtractViewPanel() {
        initComponents();
    }

    private void btnTestJavaParserOp(ActionEvent e) {
        new TestJavaParserOp().exec();
    }

    private void onBtnScenario01(ActionEvent e) {
        //new Scenario01().exec();
        new Scenario02().exec();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        btnTestJavaParserOp = new JButton();
        btnScenario01 = new JButton();
        button1 = new JButton();

        //======== this ========

        //---- btnTestJavaParserOp ----
        btnTestJavaParserOp.setText("TestJavaParserOp");
        btnTestJavaParserOp.addActionListener(e -> btnTestJavaParserOp(e));

        //---- btnScenario01 ----
        btnScenario01.setText("Scenario01");
        btnScenario01.addActionListener(e -> onBtnScenario01(e));

        //---- button1 ----
        button1.setText("text");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(btnTestJavaParserOp)
                        .addComponent(btnScenario01))
                    .addContainerGap(464, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(511, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnTestJavaParserOp)
                    .addGap(18, 18, 18)
                    .addComponent(btnScenario01)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 425, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JButton btnTestJavaParserOp;
    private JButton btnScenario01;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
