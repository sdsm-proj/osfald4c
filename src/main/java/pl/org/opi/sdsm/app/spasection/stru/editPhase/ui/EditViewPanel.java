package pl.org.opi.sdsm.app.spasection.stru.editPhase.ui;

import javax.swing.border.*;
import lombok.Getter;

import javax.swing.*;
import javax.swing.GroupLayout;

@Getter
public class EditViewPanel extends JPanel {
    public EditViewPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        label4 = new JLabel();
        separator1 = new JSeparator();
        label6 = new JLabel();
        edJavaDocumentPrefix = new JTextField();
        label7 = new JLabel();
        edJavaDtoPackage = new JTextField();
        label8 = new JLabel();
        edJavaMapperPackage = new JTextField();
        label9 = new JLabel();
        edJavaServicePackage = new JTextField();
        label10 = new JLabel();
        edJavaControllerPackage = new JTextField();
        panel2 = new JPanel();
        label5 = new JLabel();
        separator2 = new JSeparator();
        labelSectionPackageName = new JLabel();
        edSectionPackageName = new JTextField();
        label1 = new JLabel();
        edServiceOperationNameLower = new JTextField();
        label2 = new JLabel();
        edServiceOperationNameUpper = new JTextField();
        label3 = new JLabel();
        edRolePrefix = new JTextField();

        //======== this ========

        //======== panel1 ========
        {
            panel1.setBorder(new BevelBorder(BevelBorder.RAISED));

            //---- label4 ----
            label4.setText("Document level");

            //---- label6 ----
            label6.setText("Document prefix");

            //---- label7 ----
            label7.setText("Dto package");

            //---- label8 ----
            label8.setText("Mapper package");

            //---- label9 ----
            label9.setText("Service package");

            //---- label10 ----
            label10.setText("Controller package");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(separator1)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label10)
                                .addGap(0, 598, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(edJavaControllerPackage, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                                    .addComponent(edJavaServicePackage, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                                    .addComponent(edJavaDocumentPrefix, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                                    .addComponent(edJavaDtoPackage, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                                    .addComponent(edJavaMapperPackage, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(label4)
                                            .addComponent(label6)
                                            .addComponent(label7)
                                            .addComponent(label8)
                                            .addComponent(label9))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edJavaDocumentPrefix, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edJavaDtoPackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edJavaMapperPackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edJavaServicePackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label10)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edJavaControllerPackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel2 ========
        {
            panel2.setBorder(new BevelBorder(BevelBorder.RAISED));

            //---- label5 ----
            label5.setText("Section level");

            //---- labelSectionPackageName ----
            labelSectionPackageName.setText("Section package name");

            //---- label1 ----
            label1.setText("Service operation short name lower, e.g. 'edit'");

            //---- label2 ----
            label2.setText("Service operation short name upper");

            //---- edServiceOperationNameUpper ----
            edServiceOperationNameUpper.setEditable(false);

            //---- label3 ----
            label3.setText("Role prefix");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(separator2, GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label5)
                                .addContainerGap(552, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(edServiceOperationNameLower, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                                    .addComponent(edSectionPackageName, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
                                .addGap(6, 6, 6))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label3)
                                .addGap(0, 562, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(edRolePrefix, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                                    .addComponent(edServiceOperationNameUpper, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelSectionPackageName, GroupLayout.Alignment.LEADING)
                                            .addComponent(label1, GroupLayout.Alignment.LEADING)
                                            .addComponent(label2, GroupLayout.Alignment.LEADING))
                                        .addGap(0, 372, Short.MAX_VALUE)))
                                .addContainerGap())))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSectionPackageName)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edSectionPackageName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edServiceOperationNameLower, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edServiceOperationNameUpper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edRolePrefix, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(9, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel1;
    private JLabel label4;
    private JSeparator separator1;
    private JLabel label6;
    private JTextField edJavaDocumentPrefix;
    private JLabel label7;
    private JTextField edJavaDtoPackage;
    private JLabel label8;
    private JTextField edJavaMapperPackage;
    private JLabel label9;
    private JTextField edJavaServicePackage;
    private JLabel label10;
    private JTextField edJavaControllerPackage;
    private JPanel panel2;
    private JLabel label5;
    private JSeparator separator2;
    private JLabel labelSectionPackageName;
    private JTextField edSectionPackageName;
    private JLabel label1;
    private JTextField edServiceOperationNameLower;
    private JLabel label2;
    private JTextField edServiceOperationNameUpper;
    private JLabel label3;
    private JTextField edRolePrefix;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
