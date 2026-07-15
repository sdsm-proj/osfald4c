package pl.org.opi.sdsm.app.spasection.stru.extractPhase.ui;

import javax.swing.event.*;

import lombok.Getter;
import pl.org.opi.sdsm.app.spasection.oper.extractPhase.FillSections4SelectedDocumentOper;
import pl.org.opi.sdsm.app.spasection.oper.extractPhase.FillTree4SelectedSectionOper;
import pl.org.opi.sdsm.app.spasection.oper.extractPhase.RefreshAction;
import pl.org.opi.sdsm.app.spasection.oper.extractPhase.SelectPartAction;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

@Getter
public class ExtractViewPanel extends JPanel {
    public ExtractViewPanel() {
        initComponents();
        initComponents2();
    }

    public void afterShow() {
        new RefreshAction(this).exec();
    }

    public DefaultListModel<ClazzListElem> getListDocumentsModel() {
        return (DefaultListModel<ClazzListElem>)listDocuments.getModel();
    }

    public DefaultListModel<FldDefListElem> getListSectionsModel() {
        return (DefaultListModel<FldDefListElem>)listSections.getModel();
    }

    private void onBtnRefresh(ActionEvent e) {
        new RefreshAction(this).exec();
    }

    private void onListDocumentsValueChanged(ListSelectionEvent e) {
        new FillSections4SelectedDocumentOper(this).exec();
    }

    private void onListSectionsValueChanged(ListSelectionEvent e) {
        new FillTree4SelectedSectionOper(this).exec();
    }

    private void onBtnSelect(ActionEvent e) {
        new SelectPartAction(this).exec();
    }

    private void treePartMouseClicked(MouseEvent e) {
        new SelectPartAction(this).exec();
    }

    private void thisComponentShown(ComponentEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        btnSelect = new JButton();
        btnRefresh = new JButton();
        splitPane1 = new JSplitPane();
        panel1 = new JPanel();
        labelDocuments = new JLabel();
        scrollPaneDocuments = new JScrollPane();
        listDocuments = new JList();
        labelSections = new JLabel();
        scrollPaneSections = new JScrollPane();
        listSections = new JList();
        panel2 = new JPanel();
        labelPart = new JLabel();
        scrollPanePart = new JScrollPane();
        treePart = new JTree();
        edSelectedPart = new JTextField();
        labelSelectedPart = new JLabel();

        //======== this ========
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                thisComponentShown(e);
            }
        });

        //---- btnSelect ----
        btnSelect.setText("Select");
        btnSelect.addActionListener(e -> onBtnSelect(e));

        //---- btnRefresh ----
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(e -> onBtnRefresh(e));

        //======== splitPane1 ========
        {
            splitPane1.setDividerLocation(300);
            splitPane1.setDividerSize(16);

            //======== panel1 ========
            {

                //---- labelDocuments ----
                labelDocuments.setText("Documents");

                //======== scrollPaneDocuments ========
                {

                    //---- listDocuments ----
                    listDocuments.addListSelectionListener(e -> onListDocumentsValueChanged(e));
                    scrollPaneDocuments.setViewportView(listDocuments);
                }

                //---- labelSections ----
                labelSections.setText("Sections");

                //======== scrollPaneSections ========
                {

                    //---- listSections ----
                    listSections.addListSelectionListener(e -> onListSectionsValueChanged(e));
                    scrollPaneSections.setViewportView(listSections);
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addComponent(scrollPaneDocuments, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(labelDocuments)
                                .addComponent(labelSections))
                            .addGap(0, 238, Short.MAX_VALUE))
                        .addComponent(scrollPaneSections, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(labelDocuments)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPaneDocuments, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelSections)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPaneSections, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                );
            }
            splitPane1.setLeftComponent(panel1);

            //======== panel2 ========
            {

                //---- labelPart ----
                labelPart.setText("Section part to process");

                //======== scrollPanePart ========
                {

                    //---- treePart ----
                    treePart.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            treePartMouseClicked(e);
                        }
                    });
                    scrollPanePart.setViewportView(treePart);
                }

                //---- edSelectedPart ----
                edSelectedPart.setEditable(false);

                //---- labelSelectedPart ----
                labelSelectedPart.setText("Selected");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(labelPart)
                            .addGap(0, 136, Short.MAX_VALUE))
                        .addComponent(scrollPanePart, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(edSelectedPart, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(labelSelectedPart)
                            .addContainerGap(186, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(labelPart)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPanePart, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(labelSelectedPart)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edSelectedPart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
            }
            splitPane1.setRightComponent(panel2);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(splitPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRefresh)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSelect)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(splitPane1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSelect)
                        .addComponent(btnRefresh))
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JButton btnSelect;
    private JButton btnRefresh;
    private JSplitPane splitPane1;
    private JPanel panel1;
    private JLabel labelDocuments;
    private JScrollPane scrollPaneDocuments;
    private JList listDocuments;
    private JLabel labelSections;
    private JScrollPane scrollPaneSections;
    private JList listSections;
    private JPanel panel2;
    private JLabel labelPart;
    private JScrollPane scrollPanePart;
    private JTree treePart;
    private JTextField edSelectedPart;
    private JLabel labelSelectedPart;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void initComponents2() {
        initModels();
    }

    private void initModels() {
        listDocuments.setModel(new DefaultListModel<ClazzListElem>());
        listSections.setModel(new DefaultListModel<FldDefListElem>());
        //treePart.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Akuku")));
        treePart.setModel(null);
    }

}
