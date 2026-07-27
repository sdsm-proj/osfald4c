/*
 * Created by JFormDesigner on Mon Jul 27 11:48:55 CEST 2026
 */

package pl.org.opi.sdsm.app.formalsample.stru.generatePhase.ui;

import lombok.Getter;
import pl.org.opi.sdsm.app.formalsample.oper.generatePhase.GenOp;
import pl.org.opi.sdsm.app.formalsample.oper.generatePhase.SaveSrcFileOp;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

@Getter
public class GenerateViewPanel extends JPanel {
    public GenerateViewPanel() {
        initComponents();
    }

    private void onBtnGen(ActionEvent e) {
        new GenOp().exec(this);
    }

    private void onBtnSaveSrcFile(ActionEvent e) {
        new SaveSrcFileOp().exec(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        btnSaveSrcFile = new JButton();
        edJavaFileName = new JTextField();
        label1 = new JLabel();
        btnGen = new JButton();
        scrollPane1 = new JScrollPane();
        taSrcCode = new JTextArea();
        label2 = new JLabel();

        //======== this ========

        //---- btnSaveSrcFile ----
        btnSaveSrcFile.setText("Zapisz plik");
        btnSaveSrcFile.addActionListener(e -> onBtnSaveSrcFile(e));

        //---- label1 ----
        label1.setText("Klasa DTO");

        //---- btnGen ----
        btnGen.setText("Generuj kod");
        btnGen.addActionListener(e -> onBtnGen(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(taSrcCode);
        }

        //---- label2 ----
        label2.setText("Pe\u0142na nazwa pliku klasy DTO");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(edJavaFileName, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(0, 458, Short.MAX_VALUE))
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnSaveSrcFile))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
                            .addComponent(btnGen)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGen)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edJavaFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnSaveSrcFile)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JButton btnSaveSrcFile;
    private JTextField edJavaFileName;
    private JLabel label1;
    private JButton btnGen;
    private JScrollPane scrollPane1;
    private JTextArea taSrcCode;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
