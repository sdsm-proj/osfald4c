/*
 * Created by JFormDesigner on Sun Sep 29 17:52:33 CEST 2024
 */

package pl.org.opi.sdsm.frmwk.mechanics.ux.dialog.newPrj;

import java.awt.event.*;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.commons.fileDir.FileChooserUtils;
import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.mechanics.gendef.GenDef;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.io.File;
import java.io.IOException;

@Getter
public class DialogNewPrj extends JDialog {
    public DialogNewPrj(DialogNewPrjSubmit dialogSubmit) {
        super(AppCtx.getInstance().getMainWindow());
        initComponents();
        this.setLocationByPlatform(true);
        //this.setSize(500, 400);
        this.setModal(true);
        this.setLocationRelativeTo(AppCtx.getInstance().getMainWindow());
        this.setTitle("Create new project");
        //
        this.dialogSubmit = dialogSubmit;
        this.onCreate();
    }

    private void btnOk(ActionEvent e) {
        onOk();
    }

    private void btnCancel(ActionEvent e) {
        onCancel();
    }

    private void btnPrjFullFileName(ActionEvent e) {
        onSelectFile();
    }

    private final DialogNewPrjSubmit dialogSubmit;

    private final DefaultComboBoxModel modelPrjType = new DefaultComboBoxModel();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        lblPrjType = new JLabel();
        comboPrjType = new JComboBox();
        lblPrjName = new JLabel();
        edPrjShortName = new JTextField();
        label1 = new JLabel();
        edPrjFullFileName = new JTextField();
        btnPrjFullFileName = new JButton();
        btnOk = new JButton();
        btnCancel = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- lblPrjType ----
        lblPrjType.setText("Generator type");

        //---- lblPrjName ----
        lblPrjName.setText("Project name");

        //---- label1 ----
        label1.setText("Project file name");

        //---- btnPrjFullFileName ----
        btnPrjFullFileName.setText("...");
        btnPrjFullFileName.addActionListener(e -> btnPrjFullFileName(e));

        //---- btnOk ----
        btnOk.setText("OK");
        btnOk.addActionListener(e -> btnOk(e));

        //---- btnCancel ----
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(e -> btnCancel(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(edPrjShortName, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(lblPrjType)
                                .addComponent(lblPrjName)
                                .addComponent(label1))
                            .addGap(0, 552, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(edPrjFullFileName, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnPrjFullFileName, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                        .addComponent(comboPrjType, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 479, Short.MAX_VALUE)
                            .addComponent(btnOk)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancel)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(lblPrjType)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboPrjType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblPrjName)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(edPrjShortName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrjFullFileName)
                        .addComponent(edPrjFullFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel)
                        .addComponent(btnOk))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel lblPrjType;
    private JComboBox comboPrjType;
    private JLabel lblPrjName;
    private JTextField edPrjShortName;
    private JLabel label1;
    private JTextField edPrjFullFileName;
    private JButton btnPrjFullFileName;
    private JButton btnOk;
    private JButton btnCancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public GenDef getPrjDefinition() {
        GenDef def = (GenDef) comboPrjType.getSelectedItem();
        return def;
    }

    private void onOk() {
        if (!isDataValid()) {
            return;
        }
        DialogNewPrjDto dto = getDialogDto();
        this.dispose();
        dialogSubmit.onDialogOk(dto);
    }

    private DialogNewPrjDto getDialogDto() {
        DialogNewPrjDto dto = new DialogNewPrjDto();
        dto.setGenDef(this.getPrjDefinition());
        dto.setPrjShortName(this.getEdPrjShortName().getText().trim());
        dto.setPrjFullFileName(this.getEdPrjFullFileName().getText().trim());
        return dto;
    }

    private void onCancel() {
        this.dispose();
    }

    private void onCreate() {
        comboPrjType.setModel(modelPrjType);
        for(GenDef def: SdsmCtx.getInstance().getPrjTypeRegistry().getDefinitionList()) {
            modelPrjType.addElement(def);
        }
    }

    private void onSelectFile() {
        String prjExtension = getPrjExtension();
        String prjDefaultName = edPrjShortName.getText().trim() + "." + getPrjExtension();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File(FileChooserUtils.getLastSelectedPath()));
        fileChooser.setSelectedFile(new File(prjDefaultName));
        int result = fileChooser.showSaveDialog(this);
        FileChooserUtils.setLastSelectedPath(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String absName = selectedFile.getAbsolutePath();
            String name = FileChooserUtils.addExtensionIfNeeded(absName, prjExtension);
            edPrjFullFileName.setText(name);
            System.out.println(name);
        }
    }

    private String getPrjExtension() {
        GenDef def = (GenDef) comboPrjType.getSelectedItem();
        if (def != null) {
            return def.getPrjCode() + ".json";
        } else {
            throw new OsfaldRuntimeException("No extension for project file");
        }
    }

    private boolean isDataValid() {
        // Project type
        GenDef def = (GenDef) comboPrjType.getSelectedItem();
        if (def == null) {
            OsfaldMsgBox.warn("Project type is empty.");
            return false;
        }

        // Project name
        if (StringUtils.isBlank(edPrjShortName.getText())) {
            OsfaldMsgBox.warn("Project name cannot be empty.");
            return false;
        }

        // Project file name empty
        if (StringUtils.isBlank(edPrjFullFileName.getText())) {
            OsfaldMsgBox.warn("Project file name cannot be empty.");
            return false;
        }

        // Project file name wrong
        try {
            File f = new File(edPrjFullFileName.getText().trim());
            String fname = f.getCanonicalPath();
            edPrjFullFileName.setText(fname);
        } catch(IOException ex) {
            OsfaldMsgBox.warn("Project file name is wrong.");
            return false;
        }

        return true;
    }

}
