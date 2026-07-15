package pl.org.opi.sdsm.app.spasection.stru.generatePhase.ui;

import java.awt.*;
import lombok.Getter;
import pl.org.opi.sdsm.app.spasection._SpaSectionGenUtil;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.SaveArtifactOper;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.ShowArtifactOper;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.GenerateBackendAiOper;
import pl.org.opi.sdsm.app.spasection.oper.generatePhase.gen.GenerateBackendOper;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import pl.org.opi.sdsm.frmwk.mechanics.component.*;

@Getter
public class GenerateViewPanel extends JPanel {
    public GenerateViewPanel() {
        initComponents();
    }

    private void onGenBackend(ActionEvent e) {
        new GenerateBackendOper().exec();
        _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot().fireTableDataChanged();
    }

    private void onBtnSaveReplace(ActionEvent e) {
        new SaveArtifactOper(this).exec();
        _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot().fireTableDataChanged();
    }

    private void splitPane3ComponentResized(ComponentEvent e) {
    }

    private void button3(ActionEvent e) {
        new GenerateBackendAiOper().exec();
        _SpaSectionGenUtil.getModel().getOperCache().getArtifactDepot().fireTableDataChanged();
    }

    private void radioButton1(ActionEvent e) {
        new ShowArtifactOper(this).exec();
    }

    private void radioButton2(ActionEvent e) {
        new ShowArtifactOper(this).exec();
    }

    private void radioButton3(ActionEvent e) {
        new ShowArtifactOper(this).exec();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        splitPane1 = new JSplitPane();
        panel1 = new JPanel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        tableArtifacts = new JTable();
        button2 = new JButton();
        button3 = new JButton();
        panel2 = new JPanel();
        btnSaveReplace = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        splitPane2 = new JSplitPane();
        panel3 = new JPanel();
        label1 = new JLabel();
        scrollPane2 = new JScrollPane();
        textPane1 = new JTextPaneNoWrap();
        panel4 = new JPanel();
        splitPane3 = new JSplitPane();
        panel5 = new JPanel();
        label2 = new JLabel();
        scrollPane3 = new JScrollPane();
        textPane2 = new JTextPaneNoWrap();
        panel6 = new JPanel();
        label3 = new JLabel();
        scrollPane4 = new JScrollPane();
        textPane3 = new JTextPaneNoWrap();
        checkBoxAskBeforeOverwrite = new JCheckBox();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();

        //======== this ========

        //======== splitPane1 ========
        {
            splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
            splitPane1.setDividerLocation(200);
            splitPane1.setDividerSize(16);

            //======== panel1 ========
            {

                //---- button1 ----
                button1.setText("Gen backend");
                button1.addActionListener(e -> onGenBackend(e));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(tableArtifacts);
                }

                //---- button2 ----
                button2.setText("Gen frontend");

                //---- button3 ----
                button3.setText("Gen backend AI");
                button3.addActionListener(e -> button3(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(button1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button3)
                                    .addGap(18, 18, 18)
                                    .addComponent(button2)
                                    .addContainerGap(79, Short.MAX_VALUE))))
                );
            }
            splitPane1.setTopComponent(panel1);

            //======== panel2 ========
            {

                //---- btnSaveReplace ----
                btnSaveReplace.setText("Save / replace");
                btnSaveReplace.addActionListener(e -> onBtnSaveReplace(e));

                //---- button4 ----
                button4.setText("text");

                //---- button5 ----
                button5.setText("text");

                //======== splitPane2 ========
                {
                    splitPane2.setDividerLocation(350);
                    splitPane2.setDividerSize(16);

                    //======== panel3 ========
                    {

                        //---- label1 ----
                        label1.setText("Existing (Old)");

                        //======== scrollPane2 ========
                        {

                            //---- textPane1 ----
                            textPane1.setBackground(new Color(0xdddddd));
                            textPane1.setEditable(false);
                            scrollPane2.setViewportView(textPane1);
                        }

                        GroupLayout panel3Layout = new GroupLayout(panel3);
                        panel3.setLayout(panel3Layout);
                        panel3Layout.setHorizontalGroup(
                            panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel3Layout.createParallelGroup()
                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                        .addGroup(panel3Layout.createSequentialGroup()
                                            .addComponent(label1)
                                            .addContainerGap(272, Short.MAX_VALUE))))
                        );
                        panel3Layout.setVerticalGroup(
                            panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addContainerGap())
                        );
                    }
                    splitPane2.setLeftComponent(panel3);

                    //======== panel4 ========
                    {

                        //======== splitPane3 ========
                        {
                            splitPane3.setDividerLocation(321);
                            splitPane3.addComponentListener(new ComponentAdapter() {
                                @Override
                                public void componentResized(ComponentEvent e) {
                                    splitPane3ComponentResized(e);
                                }
                            });

                            //======== panel5 ========
                            {

                                //---- label2 ----
                                label2.setText("Generated (New)");

                                //======== scrollPane3 ========
                                {

                                    //---- textPane2 ----
                                    textPane2.setBackground(Color.white);
                                    textPane2.setEditable(false);
                                    scrollPane3.setViewportView(textPane2);
                                }

                                GroupLayout panel5Layout = new GroupLayout(panel5);
                                panel5.setLayout(panel5Layout);
                                panel5Layout.setHorizontalGroup(
                                    panel5Layout.createParallelGroup()
                                        .addGroup(panel5Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel5Layout.createParallelGroup()
                                                .addComponent(scrollPane3)
                                                .addGroup(panel5Layout.createSequentialGroup()
                                                    .addComponent(label2)
                                                    .addContainerGap(225, Short.MAX_VALUE))))
                                );
                                panel5Layout.setVerticalGroup(
                                    panel5Layout.createParallelGroup()
                                        .addGroup(panel5Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(label2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                            .addContainerGap())
                                );
                            }
                            splitPane3.setLeftComponent(panel5);

                            //======== panel6 ========
                            {

                                //---- label3 ----
                                label3.setText("Generated (New, AI)");

                                //======== scrollPane4 ========
                                {

                                    //---- textPane3 ----
                                    textPane3.setEditable(false);
                                    textPane3.setBackground(new Color(0xccffff));
                                    scrollPane4.setViewportView(textPane3);
                                }

                                GroupLayout panel6Layout = new GroupLayout(panel6);
                                panel6.setLayout(panel6Layout);
                                panel6Layout.setHorizontalGroup(
                                    panel6Layout.createParallelGroup()
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addGroup(panel6Layout.createSequentialGroup()
                                                    .addComponent(label3)
                                                    .addContainerGap(90, Short.MAX_VALUE))
                                                .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
                                );
                                panel6Layout.setVerticalGroup(
                                    panel6Layout.createParallelGroup()
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(label3)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                            .addContainerGap())
                                );
                            }
                            splitPane3.setRightComponent(panel6);
                        }

                        GroupLayout panel4Layout = new GroupLayout(panel4);
                        panel4.setLayout(panel4Layout);
                        panel4Layout.setHorizontalGroup(
                            panel4Layout.createParallelGroup()
                                .addComponent(splitPane3, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                        );
                        panel4Layout.setVerticalGroup(
                            panel4Layout.createParallelGroup()
                                .addComponent(splitPane3)
                        );
                    }
                    splitPane2.setRightComponent(panel4);
                }

                //---- checkBoxAskBeforeOverwrite ----
                checkBoxAskBeforeOverwrite.setText("Ask before overwrite");
                checkBoxAskBeforeOverwrite.setSelected(true);

                //---- radioButton1 ----
                radioButton1.setText("1-2");
                radioButton1.addActionListener(e -> radioButton1(e));

                //---- radioButton2 ----
                radioButton2.setText("2-3");
                radioButton2.setSelected(true);
                radioButton2.addActionListener(e -> radioButton2(e));

                //---- radioButton3 ----
                radioButton3.setText("1-3");
                radioButton3.addActionListener(e -> radioButton3(e));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(splitPane2, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(checkBoxAskBeforeOverwrite)
                                    .addGap(18, 18, 18)
                                    .addComponent(radioButton1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radioButton2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radioButton3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSaveReplace)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button5)))
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(splitPane2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button5)
                                .addComponent(button4)
                                .addComponent(btnSaveReplace)
                                .addComponent(checkBoxAskBeforeOverwrite)
                                .addComponent(radioButton1)
                                .addComponent(radioButton2)
                                .addComponent(radioButton3))
                            .addContainerGap())
                );
            }
            splitPane1.setBottomComponent(panel2);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addComponent(splitPane1)
        );

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JSplitPane splitPane1;
    private JPanel panel1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable tableArtifacts;
    private JButton button2;
    private JButton button3;
    private JPanel panel2;
    private JButton btnSaveReplace;
    private JButton button4;
    private JButton button5;
    private JSplitPane splitPane2;
    private JPanel panel3;
    private JLabel label1;
    private JScrollPane scrollPane2;
    private JTextPaneNoWrap textPane1;
    private JPanel panel4;
    private JSplitPane splitPane3;
    private JPanel panel5;
    private JLabel label2;
    private JScrollPane scrollPane3;
    private JTextPaneNoWrap textPane2;
    private JPanel panel6;
    private JLabel label3;
    private JScrollPane scrollPane4;
    private JTextPaneNoWrap textPane3;
    private JCheckBox checkBoxAskBeforeOverwrite;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
