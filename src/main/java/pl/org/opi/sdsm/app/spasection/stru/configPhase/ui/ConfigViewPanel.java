package pl.org.opi.sdsm.app.spasection.stru.configPhase.ui;

import java.awt.event.*;
import lombok.Getter;

import javax.swing.*;
import javax.swing.GroupLayout;
import pl.org.opi.sdsm.frmwk.mechanics.component.*;

@Getter
public class ConfigViewPanel extends JPanel {

    public ConfigViewPanel() {
        initComponents();
    }

    private void textArea2FocusLost(FocusEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        labelProjectRootPath = new JLabel();
        edProjectRootPath = new JTextField();
        labelSourceSubPath = new JLabel();
        edSourceSubPath = new JTextField();
        labelTargetSubPath = new JLabel();
        edTargetSubPath = new JTextField();
        labelLookForClassesSubPath = new JLabel();
        scrollPaneLookForClassesSubPath = new JScrollPane();
        taLookForClassesSubPath = new JTextAreaNoTab();
        labelJars = new JLabel();
        scrollPaneJars = new JScrollPane();
        taJars = new JTextAreaNoTab();

        //======== this ========

        //---- labelProjectRootPath ----
        labelProjectRootPath.setText("Project root path");

        //---- edProjectRootPath ----
        edProjectRootPath.setEditable(false);

        //---- labelSourceSubPath ----
        labelSourceSubPath.setText("Source sub path");

        //---- labelTargetSubPath ----
        labelTargetSubPath.setText("Target sub path");

        //---- labelLookForClassesSubPath ----
        labelLookForClassesSubPath.setText("Look for classes sub path - separators [ , ; enter ]");

        //======== scrollPaneLookForClassesSubPath ========
        {
            scrollPaneLookForClassesSubPath.setViewportView(taLookForClassesSubPath);
        }

        //---- labelJars ----
        labelJars.setText("Jars - separators [ , ; enter ]");

        //======== scrollPaneJars ========
        {
            scrollPaneJars.setViewportView(taJars);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(edProjectRootPath, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addComponent(edSourceSubPath, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addComponent(edTargetSubPath, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addComponent(scrollPaneLookForClassesSubPath, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(labelProjectRootPath)
                                .addComponent(labelSourceSubPath)
                                .addComponent(labelTargetSubPath)
                                .addComponent(labelLookForClassesSubPath)
                                .addComponent(labelJars))
                            .addGap(0, 135, Short.MAX_VALUE))
                        .addComponent(scrollPaneJars, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelProjectRootPath)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edProjectRootPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelSourceSubPath)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edSourceSubPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelTargetSubPath)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edTargetSubPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelLookForClassesSubPath)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPaneLookForClassesSubPath, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelJars)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPaneJars, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel labelProjectRootPath;
    private JTextField edProjectRootPath;
    private JLabel labelSourceSubPath;
    private JTextField edSourceSubPath;
    private JLabel labelTargetSubPath;
    private JTextField edTargetSubPath;
    private JLabel labelLookForClassesSubPath;
    private JScrollPane scrollPaneLookForClassesSubPath;
    private JTextAreaNoTab taLookForClassesSubPath;
    private JLabel labelJars;
    private JScrollPane scrollPaneJars;
    private JTextAreaNoTab taJars;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
