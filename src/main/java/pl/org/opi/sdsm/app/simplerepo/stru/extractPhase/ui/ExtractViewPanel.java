package pl.org.opi.sdsm.app.simplerepo.stru.extractPhase.ui;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop.OnClearColumnNamesUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop.OnClearTableQueryUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop.OnCopyColumnNamesUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop.OnDeleteQueryUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop.OnQuerySelectedUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop.OnRunSqlUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.queries.uop.OnSaveQueryUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop.OnMoveAvailable2ChosenUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop.OnAvailableSelectedUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop.OnChosenSelectedUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop.OnMoveChosen2AvailableUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop.OnStruChanged;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop.OnTabQueriesSelectedUop;
import pl.org.opi.sdsm.app.simplerepo.oper.extractPhase.tables.uop.OnTabTablesSelectedUop;

@Slf4j
@Getter
public class ExtractViewPanel extends javax.swing.JPanel {

    public ExtractViewPanel() {
        initComponents();
        initComponents2();
    }

    private final DefaultListModel<String> modelListAvailableTables = new DefaultListModel<>();
    private final DefaultListModel<String> modelListChosenTables = new DefaultListModel<>();
    private final DefaultListModel<String> modelListQueries = new DefaultListModel<>();
    private final ColumnsTableExtractModel modelTableTables = new ColumnsTableExtractModel();
    private final ColumnsTableExtractModel modelTableQueries = new ColumnsTableExtractModel();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane = new javax.swing.JTabbedPane();
        panelTables = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAvailableTables = new javax.swing.JList<>();
        btnTableAvail2Chosen = new javax.swing.JButton();
        btnTableChosen2Avail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listChosenTables = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btnStruChanged = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTable = new javax.swing.JTable();
        btnClearTableTable = new javax.swing.JButton();
        panelQueries = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnSaveQuery = new javax.swing.JButton();
        editQueryName = new javax.swing.JTextField();
        labelQueryName = new javax.swing.JLabel();
        btnDeleteQuery = new javax.swing.JButton();
        labelQueries = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listQueries = new javax.swing.JList<>();
        labelSqlSelect = new javax.swing.JLabel();
        btnRunSql = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaSql = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnClearTableQuery = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableQuery = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnCopyColumnNames = new javax.swing.JButton();
        btnClearColumnNames = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        taColumnNames = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        mainTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainTabbedPaneStateChanged(evt);
            }
        });

        jSplitPane2.setBackground(new java.awt.Color(204, 204, 204));
        jSplitPane2.setDividerLocation(250);
        jSplitPane2.setDividerSize(10);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setText("Available tables");

        listAvailableTables.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listAvailableTables);

        btnTableAvail2Chosen.setText(">>");
        btnTableAvail2Chosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableAvail2ChosenActionPerformed(evt);
            }
        });

        btnTableChosen2Avail.setText("<<");
        btnTableChosen2Avail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableChosen2AvailActionPerformed(evt);
            }
        });

        listChosenTables.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listChosenTables);

        jLabel2.setText("Chosen tables");

        btnStruChanged.setText("Stru changed");
        btnStruChanged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStruChangedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTableAvail2Chosen)
                    .addComponent(btnTableChosen2Avail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 461, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStruChanged)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnTableAvail2Chosen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTableChosen2Avail))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStruChanged)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jSplitPane2.setTopComponent(jPanel3);

        jLabel3.setText("Table structure:");

        jLabel4.setText("jLabel4");

        tableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableTable);

        btnClearTableTable.setText("Clear");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearTableTable)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addComponent(btnClearTableTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jPanel4);

        javax.swing.GroupLayout panelTablesLayout = new javax.swing.GroupLayout(panelTables);
        panelTables.setLayout(panelTablesLayout);
        panelTablesLayout.setHorizontalGroup(
            panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        panelTablesLayout.setVerticalGroup(
            panelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        mainTabbedPane.addTab("Tables", panelTables);

        jSplitPane1.setBackground(new java.awt.Color(204, 204, 204));
        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        btnSaveQuery.setText("Save");
        btnSaveQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveQueryActionPerformed(evt);
            }
        });

        labelQueryName.setText("Query name");

        btnDeleteQuery.setText("Delete");
        btnDeleteQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteQueryActionPerformed(evt);
            }
        });

        labelQueries.setText("Queries");

        listQueries.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listQueries);

        labelSqlSelect.setText("SQL select");

        btnRunSql.setText("Run");
        btnRunSql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunSqlActionPerformed(evt);
            }
        });

        textAreaSql.setColumns(20);
        textAreaSql.setRows(5);
        jScrollPane5.setViewportView(textAreaSql);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelQueries)
                                .addGap(261, 261, 261)
                                .addComponent(labelSqlSelect))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDeleteQuery)
                                .addGap(223, 223, 223)
                                .addComponent(labelQueryName)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(editQueryName, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSaveQuery))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRunSql)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRunSql)
                    .addComponent(labelSqlSelect)
                    .addComponent(labelQueries))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveQuery)
                    .addComponent(editQueryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQueryName)
                    .addComponent(btnDeleteQuery))
                .addContainerGap())
        );

        jSplitPane1.setTopComponent(jPanel1);

        jLabel6.setText("Query result field list");

        btnClearTableQuery.setText("Clear");
        btnClearTableQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTableQueryActionPerformed(evt);
            }
        });

        tableQuery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tableQuery);

        btnCopyColumnNames.setText("Fill");
        btnCopyColumnNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyColumnNamesActionPerformed(evt);
            }
        });

        btnClearColumnNames.setText("Clear");
        btnClearColumnNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearColumnNamesActionPerformed(evt);
            }
        });

        taColumnNames.setColumns(20);
        taColumnNames.setRows(5);
        jScrollPane7.setViewportView(taColumnNames);

        jLabel5.setText("Column names");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCopyColumnNames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearColumnNames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(btnCopyColumnNames)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearColumnNames)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearTableQuery))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnClearTableQuery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout panelQueriesLayout = new javax.swing.GroupLayout(panelQueries);
        panelQueries.setLayout(panelQueriesLayout);
        panelQueriesLayout.setHorizontalGroup(
            panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        panelQueriesLayout.setVerticalGroup(
            panelQueriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        mainTabbedPane.addTab("Queries", panelQueries);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mainTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainTabbedPaneStateChanged
        int tabIndex = mainTabbedPane.getSelectedIndex();
        switch (tabIndex) {
            case 0:
                new OnTabTablesSelectedUop().exec(this);
                break;
            case 1:
                new OnTabQueriesSelectedUop().exec(this);
                break;
        }
    }//GEN-LAST:event_mainTabbedPaneStateChanged

    private void btnTableAvail2ChosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableAvail2ChosenActionPerformed
        if (listAvailableTables.getSelectedIndex() >= 0) {
            System.out.println("" + listAvailableTables.getSelectedValue());
            new OnMoveAvailable2ChosenUop().exec(this, listAvailableTables.getSelectedValue());
        }
    }//GEN-LAST:event_btnTableAvail2ChosenActionPerformed

    private void btnTableChosen2AvailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableChosen2AvailActionPerformed
        if (listChosenTables.getSelectedIndex() >= 0) {
            System.out.println("" + listChosenTables.getSelectedValue());
            new OnMoveChosen2AvailableUop().exec(this, listChosenTables.getSelectedValue());
        }
    }//GEN-LAST:event_btnTableChosen2AvailActionPerformed

    private void btnRunSqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunSqlActionPerformed
        new OnRunSqlUop(this).exec();
    }//GEN-LAST:event_btnRunSqlActionPerformed

    private void btnClearTableQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTableQueryActionPerformed
        new OnClearTableQueryUop(this).exec();
    }//GEN-LAST:event_btnClearTableQueryActionPerformed

    private void btnSaveQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveQueryActionPerformed
        new OnSaveQueryUop(this).exec();
    }//GEN-LAST:event_btnSaveQueryActionPerformed

    private void btnDeleteQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteQueryActionPerformed
        new OnDeleteQueryUop(this).exec();
    }//GEN-LAST:event_btnDeleteQueryActionPerformed

    private void btnCopyColumnNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyColumnNamesActionPerformed
        new OnCopyColumnNamesUop(this).exec();
    }//GEN-LAST:event_btnCopyColumnNamesActionPerformed

    private void btnClearColumnNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearColumnNamesActionPerformed
        new OnClearColumnNamesUop(this).exec();
    }//GEN-LAST:event_btnClearColumnNamesActionPerformed

    private void btnStruChangedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStruChangedActionPerformed
        if (listChosenTables.getSelectedIndex() >= 0) {
            System.out.println("" + listChosenTables.getSelectedValue());
            new OnStruChanged().exec(this, listChosenTables.getSelectedValue());
        }
    }//GEN-LAST:event_btnStruChangedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearColumnNames;
    private javax.swing.JButton btnClearTableQuery;
    private javax.swing.JButton btnClearTableTable;
    private javax.swing.JButton btnCopyColumnNames;
    private javax.swing.JButton btnDeleteQuery;
    private javax.swing.JButton btnRunSql;
    private javax.swing.JButton btnSaveQuery;
    private javax.swing.JButton btnStruChanged;
    private javax.swing.JButton btnTableAvail2Chosen;
    private javax.swing.JButton btnTableChosen2Avail;
    private javax.swing.JTextField editQueryName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel labelQueries;
    private javax.swing.JLabel labelQueryName;
    private javax.swing.JLabel labelSqlSelect;
    private javax.swing.JList<String> listAvailableTables;
    private javax.swing.JList<String> listChosenTables;
    private javax.swing.JList<String> listQueries;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JPanel panelQueries;
    private javax.swing.JPanel panelTables;
    private javax.swing.JTextArea taColumnNames;
    private javax.swing.JTable tableQuery;
    private javax.swing.JTable tableTable;
    private javax.swing.JTextArea textAreaSql;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        //
        listAvailableTables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listAvailableTables.setModel(modelListAvailableTables);
        listAvailableTables.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                if (listAvailableTables.getSelectedIndex() >= 0) {
                    listChosenTables.clearSelection();
                    new OnAvailableSelectedUop().exec(this, listAvailableTables.getSelectedValue());
                }
            }
        });
        //
        listChosenTables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listChosenTables.setModel(modelListChosenTables);
        listChosenTables.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                if (listChosenTables.getSelectedIndex() >= 0) {
                    listAvailableTables.clearSelection();
                    new OnChosenSelectedUop().exec(this, listChosenTables.getSelectedValue());
                }
            }
        });
        //
        listQueries.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listQueries.setModel(modelListQueries);
        listQueries.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                if (listQueries.getSelectedIndex() >= 0) {
                    System.out.println("Query: " + listQueries.getSelectedValue());
                    new OnQuerySelectedUop(this).exec(listQueries.getSelectedValue());
                }
            }
        });
        //
        tableTable.setModel(modelTableTables);
        //
        tableQuery.setModel(modelTableQueries);
        //
    }

}
