package pl.org.opi.sdsm.frmwk.steppanel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.org.opi.sdsm.frmwk.mechanics.AppCtx;
import pl.org.opi.sdsm.frmwk.mechanics.component.JTextPaneNoWrap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

@Getter
@RequiredArgsConstructor
public class StepPanel {

    private final String tabLabel;
    private final boolean buttonPrepareEnabled;
    private final boolean buttonDoItEnabled;
    private final boolean buttonSaveEnabled;
    private final boolean buttonNextEnabled;

    private JTabbedPane parentTabbedPane;

    private JPanel mainStepPanel;
    private JSplitPane splitPane;
    private JButton buttonPrepare;
    private JButton buttonDoIt;
    private JButton buttonSave;
    private JButton buttonNext;

    private JScrollPane scrollPane1;
    private JTextPaneNoWrap textPane1;
    private JScrollPane scrollPane2;
    private JTextPaneNoWrap textPane2;

    public void createJoin(JTabbedPane parent) {
        this.parentTabbedPane = parent;
        createUi();
    }

    private void createUi() {
        mainStepPanel = new JPanel();
        splitPane = new JSplitPane();

        buttonPrepare = new JButton();
        buttonDoIt = new JButton();
        buttonSave = new JButton();
        buttonNext = new JButton();

        if (!buttonPrepareEnabled) buttonPrepare.setEnabled(false);
        if (!buttonDoItEnabled) buttonDoIt.setEnabled(false);
        if (!buttonSaveEnabled) buttonSave.setEnabled(false);
        if (!buttonNextEnabled) buttonNext.setEnabled(false);

        buttonPrepare.setText("Prepare");
        buttonDoIt.setText("DoIt");
        buttonSave.setText("Save");
        buttonNext.setText("Next >>");

        splitPane.setDividerLocation((int)(AppCtx.getInstance().getMainWindow().getWidth() * 0.48));
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPaneNoWrap();
        scrollPane2 = new JScrollPane();
        textPane2 = new JTextPaneNoWrap();

        scrollPane1.setViewportView(textPane1);
        splitPane.setLeftComponent(scrollPane1);

        scrollPane2.setViewportView(textPane2);
        splitPane.setRightComponent(scrollPane2);

        GroupLayout panel1Layout = new GroupLayout(mainStepPanel);
        mainStepPanel.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(buttonPrepare)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonDoIt)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonSave)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonNext)
                                                .addContainerGap(406, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonPrepare)
                                        .addComponent(buttonDoIt)
                                        .addComponent(buttonSave)
                                        .addComponent(buttonNext))
                                .addContainerGap())
        );

        parentTabbedPane.addTab(tabLabel, mainStepPanel);

        mainStepPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                splitPane.setDividerLocation((int)(AppCtx.getInstance().getMainWindow().getWidth() * 0.48));
            }
        });

    }

    public static void connectAsyncOper(JButton btn, StepPanel sp, Runnable r) {
        btn.addActionListener(e -> {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    AppCtx.getInstance().getMainWindow().waitStart();
                }
            });
            EventQueue.invokeLater(r);
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    AppCtx.getInstance().getMainWindow().waitStop();
                }
            });
        });

    }

}
