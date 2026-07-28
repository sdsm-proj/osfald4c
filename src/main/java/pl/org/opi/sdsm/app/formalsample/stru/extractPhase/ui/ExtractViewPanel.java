/*
 * Created by JFormDesigner on Mon Jul 27 11:48:26 CEST 2026
 */

package pl.org.opi.sdsm.app.formalsample.stru.extractPhase.ui;

import lombok.Getter;
import pl.org.opi.sdsm.app.formalsample.oper.extractPhase.LoadTablesOp;
import pl.org.opi.sdsm.app.formalsample.oper.extractPhase.SelectTableOp;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop.OnAvailableSelectedUop;
import pl.org.opi.sdsm.frmwk.mechanics.SdsmCtx;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.ListSelectionEvent;

@Getter
public class ExtractViewPanel extends JPanel {
    private final DefaultListModel<String> listTablesModel = new DefaultListModel<>();


    public ExtractViewPanel() {
        initComponents();
        initComponents2();
    }

    private void onBtnLoadTables(ActionEvent e) {
        new LoadTablesOp().exec(this);
    }

    private void onBtnSelectTable(ActionEvent e) {
        new SelectTableOp().exec(this);
    }

    private void onBtnNextPhase(ActionEvent e) {
        SdsmCtx.getInstance().getCurrGen().showPhase(EnumPhase.EDIT);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();
        btnLoadTables = new JButton();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        listTables = new JList();
        btnSelectTable = new JButton();
        scrollPane2 = new JScrollPane();
        taFieldsExtracted = new JTextArea();
        btnNextPhase = new JButton();

        //======== this ========

        //---- label1 ----
        label1.setText("Wska\u017c tabel\u0119, dla kt\u00f3rej ma powsta\u0107 DTO");

        //---- btnLoadTables ----
        btnLoadTables.setText("Pobierz list\u0119 tabel");
        btnLoadTables.addActionListener(e -> onBtnLoadTables(e));

        //---- label2 ----
        label2.setText("Pobrana lista p\u00f3l i typ\u00f3w wskazanej tabeli");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(listTables);
        }

        //---- btnSelectTable ----
        btnSelectTable.setText(">>");
        btnSelectTable.addActionListener(e -> onBtnSelectTable(e));

        //======== scrollPane2 ========
        {

            //---- taFieldsExtracted ----
            taFieldsExtracted.setEditable(false);
            scrollPane2.setViewportView(taFieldsExtracted);
        }

        //---- btnNextPhase ----
        btnNextPhase.setText("Kolejna faza >>");
        btnNextPhase.addActionListener(e -> onBtnNextPhase(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(btnLoadTables)
                                        .addComponent(label1))
                                    .addGap(90, 90, 90))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSelectTable)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(0, 158, Short.MAX_VALUE))
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 567, Short.MAX_VALUE)
                            .addComponent(btnNextPhase)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnLoadTables)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                        .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(btnSelectTable)
                            .addGap(0, 119, Short.MAX_VALUE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnNextPhase)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JButton btnLoadTables;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JList listTables;
    private JButton btnSelectTable;
    private JScrollPane scrollPane2;
    private JTextArea taFieldsExtracted;
    private JButton btnNextPhase;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void initComponents2() {
        listTables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listTables.setModel(listTablesModel);
        listTables.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                if (listTables.getSelectedIndex() >= 0) {
                    //new OnAvailableSelectedUop().exec(this, listAvailableTables.getSelectedValue());
                }
            }
        });
    }

}
