package pl.org.opi.sdsm.app.simplerepo.stru.generatePhase.ui;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.op.DefaultQryNames;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop.OnChosenQryDeselectedUop;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop.OnChosenQrySelectedUop;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop.OnGenerateQueryUop;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop.OnSaveQryUop;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.queries.uop.OnTabQrySelectedUop;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.op.DefaultNames;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.uop.OnChosenDeselectedUop;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.uop.OnChosenSelectedUop;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.uop.OnGenerateTableUop;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.uop.OnSaveUop;
import pl.org.opi.sdsm.app.simplerepo.oper.generatePhase.tables.uop.OnTabTablesSelectedUop;
import pl.org.opi.sdsm.frmwk.mechanics.exception.OsfaldRuntimeException;
import pl.org.opi.sdsm.frmwk.util.filePathPckg.FilePathPckg;
import pl.org.opi.sdsm.frmwk.util.msgbox.OsfaldMsgBox;

@Getter
public class GenerateViewPanel extends javax.swing.JPanel {

    public GenerateViewPanel() {
        initComponents();
        initComponents2();
        initComponents3();
    }

    private DefaultListModel<String> modelListChosenTables = new DefaultListModel<>();
    private DefaultListModel<String> modelListChosenQ = new DefaultListModel<>();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane = new javax.swing.JTabbedPane();
        panelTables = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listChosenTables = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        edRepositoryPathAbs = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edRepositoryClassName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edEntityPathAbs = new javax.swing.JTextField();
        edEntityClassName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        edTestPathAbs = new javax.swing.JTextField();
        edTestClassName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        edRepositoryPathRel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnRepositoryPathConvert = new javax.swing.JButton();
        btnEntityPathConvert = new javax.swing.JButton();
        edEntityPathRel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnTestPathConvert = new javax.swing.JButton();
        edTestPathRel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnDefaultRepositoryClassName = new javax.swing.JButton();
        btnDefaultEntityClassName = new javax.swing.JButton();
        btnDefaultTestClassName = new javax.swing.JButton();
        panelQueries = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listChosenQueries = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        edQueryClassName = new javax.swing.JTextField();
        btnDefaultQryClassName = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        edQueryPathAbs = new javax.swing.JTextField();
        btnQryPathConvert = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        edQueryPathRel = new javax.swing.JTextField();
        btnQrySave = new javax.swing.JButton();
        btnGenerateQuery = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        edQueryEntityName = new javax.swing.JTextField();
        btnDefaultQryEntityName = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        edQryTestClassName = new javax.swing.JTextField();
        edQryTestPathAbs = new javax.swing.JTextField();
        edQryTestPathRel = new javax.swing.JTextField();
        btnDefaultQryTestClassName = new javax.swing.JButton();
        btnQryTestPathConvert = new javax.swing.JButton();

        mainTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainTabbedPaneStateChanged(evt);
            }
        });

        jLabel2.setText("Tables");

        listChosenTables.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listChosenTables);

        jLabel1.setText("Repository path (absolute)");

        jLabel3.setText("Repository class name");

        jLabel4.setText("Entity path (absolute)");

        jLabel5.setText("Entity class name");

        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel6.setText("Test path (absolute)");

        jLabel7.setText("Test class name");

        edRepositoryPathRel.setEditable(false);

        jLabel8.setText("Repository path (relative)");

        btnRepositoryPathConvert.setText("Convert");
        btnRepositoryPathConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepositoryPathConvertActionPerformed(evt);
            }
        });

        btnEntityPathConvert.setText("Convert");
        btnEntityPathConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntityPathConvertActionPerformed(evt);
            }
        });

        edEntityPathRel.setEditable(false);

        jLabel9.setText("Entity path (relative)");

        btnTestPathConvert.setText("Convert");
        btnTestPathConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestPathConvertActionPerformed(evt);
            }
        });

        edTestPathRel.setEditable(false);

        jLabel10.setText("Test path (relative)");

        btnDefaultRepositoryClassName.setText("Default");
        btnDefaultRepositoryClassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultRepositoryClassNameActionPerformed(evt);
            }
        });

        btnDefaultEntityClassName.setText("Default");
        btnDefaultEntityClassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultEntityClassNameActionPerformed(evt);
            }
        });

        btnDefaultTestClassName.setText("Default");
        btnDefaultTestClassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultTestClassNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablesLayout = new javax.swing.GroupLayout(panelTables);
        panelTables.setLayout(panelTablesLayout);
        panelTablesLayout.setHorizontalGroup(
            panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablesLayout.createSequentialGroup()
                        .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 342, Short.MAX_VALUE))
                    .addGroup(panelTablesLayout.createSequentialGroup()
                        .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablesLayout.createSequentialGroup()
                                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(edRepositoryClassName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edRepositoryPathAbs, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edRepositoryPathRel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRepositoryPathConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDefaultRepositoryClassName, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablesLayout.createSequentialGroup()
                                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(edEntityPathRel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edEntityClassName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edEntityPathAbs))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEntityPathConvert)
                                    .addComponent(btnDefaultEntityClassName, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablesLayout.createSequentialGroup()
                                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(edTestPathRel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edTestClassName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edTestPathAbs))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTestPathConvert)
                                    .addComponent(btnDefaultTestClassName, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelTablesLayout.setVerticalGroup(
            panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edEntityClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnDefaultEntityClassName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edEntityPathAbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnEntityPathConvert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edEntityPathRel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edRepositoryClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnDefaultRepositoryClassName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edRepositoryPathAbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRepositoryPathConvert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edRepositoryPathRel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edTestClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnDefaultTestClassName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edTestPathAbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTestPathConvert)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edTestPathRel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnGenerate)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Tables", panelTables);

        jLabel11.setText("Queries");

        listChosenQueries.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listChosenQueries);

        jLabel12.setText("Query class name");

        btnDefaultQryClassName.setText("Default");
        btnDefaultQryClassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultQryClassNameActionPerformed(evt);
            }
        });

        jLabel13.setText("Query path (absolute)");

        btnQryPathConvert.setText("Convert");
        btnQryPathConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQryPathConvertActionPerformed(evt);
            }
        });

        jLabel14.setText("Query path (relative)");

        edQueryPathRel.setEditable(false);

        btnQrySave.setText("Save");
        btnQrySave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQrySaveActionPerformed(evt);
            }
        });

        btnGenerateQuery.setText("Generate");
        btnGenerateQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateQueryActionPerformed(evt);
            }
        });

        jLabel15.setText("Query entity class name");

        btnDefaultQryEntityName.setText("Default");
        btnDefaultQryEntityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultQryEntityNameActionPerformed(evt);
            }
        });

        jLabel16.setText("Test class name");

        jLabel17.setText("Test path (absolute)");

        jLabel18.setText("Test path (relative)");

        edQryTestPathRel.setEditable(false);

        btnDefaultQryTestClassName.setText("Default");
        btnDefaultQryTestClassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultQryTestClassNameActionPerformed(evt);
            }
        });

        btnQryTestPathConvert.setText("Convert");
        btnQryTestPathConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQryTestPathConvertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelQueriesLayout = new javax.swing.GroupLayout(panelQueries);
        panelQueries.setLayout(panelQueriesLayout);
        panelQueriesLayout.setHorizontalGroup(
            panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQueriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQueriesLayout.createSequentialGroup()
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 342, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQueriesLayout.createSequentialGroup()
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edQueryClassName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edQueryPathAbs, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edQueryPathRel)
                            .addComponent(edQueryEntityName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnQryPathConvert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDefaultQryClassName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDefaultQryEntityName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQueriesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerateQuery, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnQrySave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQueriesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edQryTestPathRel)
                            .addComponent(edQryTestPathAbs, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edQryTestClassName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQryTestPathConvert)
                            .addComponent(btnDefaultQryTestClassName, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        panelQueriesLayout.setVerticalGroup(
            panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQueriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelQueriesLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edQueryClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(btnDefaultQryClassName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(edQueryEntityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDefaultQryEntityName))
                        .addGap(4, 4, 4)
                        .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(edQueryPathAbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQryPathConvert))
                        .addGap(28, 28, 28))
                    .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edQueryPathRel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addGap(18, 18, 18)
                .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edQryTestClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(btnDefaultQryTestClassName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edQryTestPathAbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQryTestPathConvert)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edQryTestPathRel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(btnQrySave)
                .addGap(18, 18, 18)
                .addComponent(btnGenerateQuery)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Queries", panelQueries);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mainTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainTabbedPaneStateChanged
        int tabIndex = mainTabbedPane.getSelectedIndex();
        switch (tabIndex) {
            case 0:
                new OnTabTablesSelectedUop().exec(this);
                break;
            case 1:
                new OnTabQrySelectedUop().exec(this);
                break;
        }
    }//GEN-LAST:event_mainTabbedPaneStateChanged

    private void btnRepositoryPathConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepositoryPathConvertActionPerformed
        String abs = edRepositoryPathAbs.getText();
        String rel = FilePathPckg.absolutePath2RelativePath(abs);
        edRepositoryPathRel.setText(rel);
    }//GEN-LAST:event_btnRepositoryPathConvertActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        new OnSaveUop(this).exec();
        new OnGenerateTableUop(this).exec();
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        new OnSaveUop(this).exec();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEntityPathConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntityPathConvertActionPerformed
        String abs = edEntityPathAbs.getText();
        String rel = FilePathPckg.absolutePath2RelativePath(abs);
        edEntityPathRel.setText(rel);
    }//GEN-LAST:event_btnEntityPathConvertActionPerformed

    private void btnTestPathConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestPathConvertActionPerformed
        String abs = edTestPathAbs.getText();
        String rel = FilePathPckg.absolutePath2RelativePath(abs);
        edTestPathRel.setText(rel);
    }//GEN-LAST:event_btnTestPathConvertActionPerformed

    private void btnQryPathConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQryPathConvertActionPerformed
        String abs = edQueryPathAbs.getText();
        String rel = FilePathPckg.absolutePath2RelativePath(abs);
        edQueryPathRel.setText(rel);
    }//GEN-LAST:event_btnQryPathConvertActionPerformed

    private void btnQrySaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQrySaveActionPerformed
        new OnSaveQryUop(this).exec();
    }//GEN-LAST:event_btnQrySaveActionPerformed

    private void btnGenerateQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateQueryActionPerformed
        new OnGenerateQueryUop(this).exec();
    }//GEN-LAST:event_btnGenerateQueryActionPerformed

    private void btnDefaultRepositoryClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultRepositoryClassNameActionPerformed
        String tableName = getListChosenTables().getSelectedValue();
        if (StringUtils.isBlank(tableName)) {
            OsfaldMsgBox.error("Choose table first.");
            return;
        }
        edRepositoryClassName.setText(DefaultNames.defaultRepositoryClassName(tableName));
    }//GEN-LAST:event_btnDefaultRepositoryClassNameActionPerformed

    private void btnDefaultEntityClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultEntityClassNameActionPerformed
        String tableName = getListChosenTables().getSelectedValue();
        if (StringUtils.isBlank(tableName)) {
            OsfaldMsgBox.error("Choose table first.");
            return;
        }
        edEntityClassName.setText(DefaultNames.defaultEntityClassName(tableName));
    }//GEN-LAST:event_btnDefaultEntityClassNameActionPerformed

    private void btnDefaultTestClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultTestClassNameActionPerformed
        String tableName = getListChosenTables().getSelectedValue();
        if (StringUtils.isBlank(tableName)) {
            OsfaldMsgBox.error("Choose table first.");
            return;
        }
        edTestClassName.setText(DefaultNames.defaultTestClassName(tableName));
    }//GEN-LAST:event_btnDefaultTestClassNameActionPerformed

    private void btnDefaultQryTestClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultQryTestClassNameActionPerformed
        String qryName = getListChosenQueries().getSelectedValue();
        if (StringUtils.isBlank(qryName)) {
            OsfaldMsgBox.error("Choose query first.");
            return;
        }
        edQryTestClassName.setText(DefaultQryNames.defaultQryTestClassName(qryName));
    }//GEN-LAST:event_btnDefaultQryTestClassNameActionPerformed

    private void btnQryTestPathConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQryTestPathConvertActionPerformed
        String abs = edQryTestPathAbs.getText();
        String rel = FilePathPckg.absolutePath2RelativePath(abs);
        edQryTestPathRel.setText(rel);
    }//GEN-LAST:event_btnQryTestPathConvertActionPerformed

    private void btnDefaultQryClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultQryClassNameActionPerformed
        String qryName = getListChosenQueries().getSelectedValue();
        if (StringUtils.isBlank(qryName)) {
            OsfaldMsgBox.error("Choose query first.");
            return;
        }
        edQueryClassName.setText(DefaultQryNames.defaultQryClassName(qryName));
    }//GEN-LAST:event_btnDefaultQryClassNameActionPerformed

    private void btnDefaultQryEntityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultQryEntityNameActionPerformed
        String qryName = getListChosenQueries().getSelectedValue();
        if (StringUtils.isBlank(qryName)) {
            OsfaldMsgBox.error("Choose query first.");
            return;
        }
        edQueryEntityName.setText(DefaultQryNames.defaultQryEntityName(qryName));
    }//GEN-LAST:event_btnDefaultQryEntityNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDefaultEntityClassName;
    private javax.swing.JButton btnDefaultQryClassName;
    private javax.swing.JButton btnDefaultQryEntityName;
    private javax.swing.JButton btnDefaultQryTestClassName;
    private javax.swing.JButton btnDefaultRepositoryClassName;
    private javax.swing.JButton btnDefaultTestClassName;
    private javax.swing.JButton btnEntityPathConvert;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnGenerateQuery;
    private javax.swing.JButton btnQryPathConvert;
    private javax.swing.JButton btnQrySave;
    private javax.swing.JButton btnQryTestPathConvert;
    private javax.swing.JButton btnRepositoryPathConvert;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTestPathConvert;
    private javax.swing.JTextField edEntityClassName;
    private javax.swing.JTextField edEntityPathAbs;
    private javax.swing.JTextField edEntityPathRel;
    private javax.swing.JTextField edQryTestClassName;
    private javax.swing.JTextField edQryTestPathAbs;
    private javax.swing.JTextField edQryTestPathRel;
    private javax.swing.JTextField edQueryClassName;
    private javax.swing.JTextField edQueryEntityName;
    private javax.swing.JTextField edQueryPathAbs;
    private javax.swing.JTextField edQueryPathRel;
    private javax.swing.JTextField edRepositoryClassName;
    private javax.swing.JTextField edRepositoryPathAbs;
    private javax.swing.JTextField edRepositoryPathRel;
    private javax.swing.JTextField edTestClassName;
    private javax.swing.JTextField edTestPathAbs;
    private javax.swing.JTextField edTestPathRel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listChosenQueries;
    private javax.swing.JList<String> listChosenTables;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JPanel panelQueries;
    private javax.swing.JPanel panelTables;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        //
        listChosenTables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listChosenTables.setModel(modelListChosenTables);
        listChosenTables.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                if (listChosenTables.getSelectedIndex() >= 0) {
                    new OnChosenSelectedUop().exec(this, listChosenTables.getSelectedValue());
                } else {
                    new OnChosenDeselectedUop().exec(this);
                }
            }
        });
        //
        listChosenQueries.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listChosenQueries.setModel(modelListChosenQ);
        listChosenQueries.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                if (listChosenQueries.getSelectedIndex() >= 0) {
                    new OnChosenQrySelectedUop().exec(this, listChosenQueries.getSelectedValue());
                } else {
                    new OnChosenQryDeselectedUop().exec(this);
                }
            }
        });
        //
    }

    private void initComponents3() {
    }

}
