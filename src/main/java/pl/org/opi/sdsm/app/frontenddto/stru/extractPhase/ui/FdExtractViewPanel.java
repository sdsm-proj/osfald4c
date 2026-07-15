/*
 * Created by JFormDesigner on Tue Aug 05 11:55:47 CEST 2025
 */

package pl.org.opi.sdsm.app.frontenddto.stru.extractPhase.ui;

import java.awt.*;
import java.beans.*;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.frontenddto._FrontendDtoGenUtil;
import pl.org.opi.sdsm.app.frontenddto.model.var.EnumDtoVariant;
import pl.org.opi.sdsm.app.frontenddto.oper.extractPhase.ClearSelectedDto;
import pl.org.opi.sdsm.app.frontenddto.oper.extractPhase.ReadSelectedDto;
import pl.org.opi.sdsm.app.frontenddto.oper.extractPhase.ReadSrcFileListOper;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.uc.gen.UcPhaseSelect;

@Slf4j
public class FdExtractViewPanel extends JPanel {
    public FdExtractViewPanel() {
        initComponents();
        initComponents2();
    }

    private void btnReadProject(ActionEvent e) {
        new ReadSrcFileListOper().exec();

        getListOfDtoModel().clear();
        var vars = _FrontendDtoGenUtil.getModel().getVars();
        for (var fr: vars.getAllSrcDtoFrList()) {
            getListOfDtoModel().addElement(fr);
        }
    }

    private void edFind(ActionEvent e) {
        // TODO add your code here
    }

    private void edFindPropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void edFindKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void btnGotoGen(ActionEvent e) {
        new UcPhaseSelect().exec(EnumPhase.GENERATE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        btnReadProject = new JButton();
        scrollPane1 = new JScrollPane();
        listOfDto = new JList();
        edFind = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        panel1 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        btnGotoGen = new JButton();
        labelDtoVariant = new JLabel();
        label6 = new JLabel();
        edFilePath = new JTextField();
        scrollPane2 = new JScrollPane();
        edSourceOfDto = new JTextArea();

        //======== this ========

        //---- btnReadProject ----
        btnReadProject.setText("Read project");
        btnReadProject.addActionListener(e -> btnReadProject(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(listOfDto);
        }

        //---- edFind ----
        edFind.addActionListener(e -> edFind(e));
        edFind.addPropertyChangeListener("text", e -> edFindPropertyChange(e));
        edFind.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                edFindKeyPressed(e);
            }
        });

        //---- label1 ----
        label1.setText("List of DTO");

        //---- label2 ----
        label2.setText("Find");

        //======== panel1 ========
        {

            //---- label3 ----
            label3.setText("Full file name");

            //---- label4 ----
            label4.setText("Source code");

            //---- btnGotoGen ----
            btnGotoGen.setText("Go to generator");
            btnGotoGen.addActionListener(e -> btnGotoGen(e));

            //---- labelDtoVariant ----
            labelDtoVariant.setText("...");

            //---- label6 ----
            label6.setText("DTO variant");

            //======== scrollPane2 ========
            {

                //---- edSourceOfDto ----
                edSourceOfDto.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 11));
                scrollPane2.setViewportView(edSourceOfDto);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addComponent(edFilePath)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label6)
                                .addGap(18, 18, 18)
                                .addComponent(labelDtoVariant, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label3)
                                    .addComponent(label4)
                                    .addComponent(btnGotoGen))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edFilePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(labelDtoVariant))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGotoGen)
                        .addContainerGap())
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label2)
                        .addComponent(label1)
                        .addComponent(btnReadProject)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                        .addComponent(edFind, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnReadProject)
                            .addGap(18, 18, 18)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edFind, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void initComponents2() {
        _FrontendDtoGenUtil.getModel().getVars().setSelectedDto(null);
        listOfDto.setModel(new DefaultListModel());
        edFind.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                findDto();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                findDto();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                findDto();
            }
        });
        listOfDto.addListSelectionListener(event -> onListOfDtoValueChanged(event));
        updateAfterDtoSelected();
    }

    private DefaultListModel getListOfDtoModel() {
        return (DefaultListModel)listOfDto.getModel();
    }

    private void findDto() {
        String findText = edFind.getText().trim();
        if (StringUtils.isBlank(findText)) {
            return;
        }

        for(int i = 0; i < getListOfDtoModel().size(); i++) {
            FileRender fr = (FileRender) getListOfDtoModel().get(i);
            if (fr.getFile().getName().toLowerCase().contains(findText.toLowerCase())) {
                listOfDto.setSelectedIndex(i);
                listOfDto.ensureIndexIsVisible(i);
                break;
            }
        }
    }

    private void onListOfDtoValueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {
            if (listOfDto.getSelectedIndex() >= 0) {
                new ReadSelectedDto().exec((FileRender) getListOfDtoModel().get(listOfDto.getSelectedIndex()));
                updateAfterDtoSelected();
            } else {
                new ClearSelectedDto().exec();
                updateAfterDtoSelected();
            }
        }
    }

    private void updateAfterDtoSelected() {
        var selDto = _FrontendDtoGenUtil.getModel().getVars().getSelectedDto();
        if (selDto == null) {
            edFilePath.setText("");
            edSourceOfDto.setText("");
            labelDtoVariant.setText("???");
            btnGotoGen.setEnabled(false);
        } else {
            edFilePath.setText(selDto.getFile().getAbsolutePath());
            edSourceOfDto.setText(selDto.getSourceText());
            labelDtoVariant.setText(selDto.getDtoVariant().toString());
            if (!(EnumDtoVariant.NONE.equals(selDto.getDtoVariant()))) {
                btnGotoGen.setEnabled(true);
            }
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JButton btnReadProject;
    private JScrollPane scrollPane1;
    private JList listOfDto;
    private JTextField edFind;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;
    private JLabel label3;
    private JLabel label4;
    private JButton btnGotoGen;
    private JLabel labelDtoVariant;
    private JLabel label6;
    private JTextField edFilePath;
    private JScrollPane scrollPane2;
    private JTextArea edSourceOfDto;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
