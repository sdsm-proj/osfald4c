/*
 * Created by JFormDesigner on Sun Sep 29 12:47:22 CEST 2024
 */

package pl.org.opi.sdsm.frmwk.mechanics;

import java.awt.*;
import lombok.Getter;
import pl.org.opi.sdsm.frmwk.mechanics.phaseview.EnumPhase;
import pl.org.opi.sdsm.frmwk.mechanics.uc.gen.ActPhaseSelect;
import pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu.ActClosePrj;
import pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu.ActNewPrj;
import pl.org.opi.sdsm.frmwk.mechanics.uc.ucmenu.ActOpenPrj;

import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;

@Getter
public class MainWindow extends JFrame {
    public MainWindow() {
        this.MW = this;
        initComponents();

        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension((int)(screenDim.getWidth() * 0.6), (int)(screenDim.getHeight() * 0.7)));
        int x = (int) ((screenDim.getWidth() - this.getWidth()) / 2);
        int y = (int) ((screenDim.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
        waitHide();
    }

    private void miNewPrj(ActionEvent e) {
        new ActNewPrj().exec();
    }

    private void miOpenPrj(ActionEvent e) {
        new ActOpenPrj().exec();
    }

    private void miForceSavePrj(ActionEvent e) {
        // TODO add your code here
    }

    private void miClosePrj(ActionEvent e) {
        new ActClosePrj().exec();
    }

    private void miPh01(ActionEvent e) {
        new ActPhaseSelect().exec(EnumPhase.CONFIG);
    }

    private void miPh02(ActionEvent e) {
        new ActPhaseSelect().exec(EnumPhase.EXTRACT);
    }

    private void miPh03(ActionEvent e) {
        new ActPhaseSelect().exec(EnumPhase.EDIT);
    }

    private void miPh04(ActionEvent e) {
        new ActPhaseSelect().exec(EnumPhase.GENERATE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        menuBar1 = new JMenuBar();
        menuFile = new JMenu();
        miNewPrj = new JMenuItem();
        miOpenPrj = new JMenuItem();
        miForceSavePrj = new JMenuItem();
        miPrjProps = new JMenuItem();
        miClosePrj = new JMenuItem();
        menuPhase = new JMenu();
        miPh01 = new JMenuItem();
        miPh02 = new JMenuItem();
        miPh03 = new JMenuItem();
        miPh04 = new JMenuItem();
        labelPhase = new JLabel();
        labelPrj = new JLabel();
        panelMain = new JPanel();
        labelWait = new JLabel();
        labelTime = new JLabel();

        //======== this ========
        setTitle("Osfald4a");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menuFile ========
            {
                menuFile.setText("File");

                //---- miNewPrj ----
                miNewPrj.setText("New project");
                miNewPrj.addActionListener(e -> miNewPrj(e));
                menuFile.add(miNewPrj);

                //---- miOpenPrj ----
                miOpenPrj.setText("Open project");
                miOpenPrj.addActionListener(e -> miOpenPrj(e));
                menuFile.add(miOpenPrj);
                menuFile.addSeparator();

                //---- miForceSavePrj ----
                miForceSavePrj.setText("Save project");
                miForceSavePrj.addActionListener(e -> miForceSavePrj(e));
                menuFile.add(miForceSavePrj);
                menuFile.addSeparator();

                //---- miPrjProps ----
                miPrjProps.setText("Project properties");
                menuFile.add(miPrjProps);
                menuFile.addSeparator();

                //---- miClosePrj ----
                miClosePrj.setText("Close project");
                miClosePrj.addActionListener(e -> miClosePrj(e));
                menuFile.add(miClosePrj);
            }
            menuBar1.add(menuFile);

            //======== menuPhase ========
            {
                menuPhase.setText("SDSM Phase");

                //---- miPh01 ----
                miPh01.setText("SDSM Config");
                miPh01.addActionListener(e -> miPh01(e));
                menuPhase.add(miPh01);

                //---- miPh02 ----
                miPh02.setText("SDSM Extract");
                miPh02.addActionListener(e -> miPh02(e));
                menuPhase.add(miPh02);

                //---- miPh03 ----
                miPh03.setText("SDSM Edit");
                miPh03.addActionListener(e -> miPh03(e));
                menuPhase.add(miPh03);

                //---- miPh04 ----
                miPh04.setText("SDSM Generate code");
                miPh04.addActionListener(e -> miPh04(e));
                menuPhase.add(miPh04);
            }
            menuBar1.add(menuPhase);
        }
        setJMenuBar(menuBar1);

        //---- labelPhase ----
        labelPhase.setText(" ");
        labelPhase.setHorizontalAlignment(SwingConstants.RIGHT);

        //---- labelPrj ----
        labelPrj.setText(" ");

        //======== panelMain ========
        {
            panelMain.setPreferredSize(new Dimension(100, 100));

            GroupLayout panelMainLayout = new GroupLayout(panelMain);
            panelMain.setLayout(panelMainLayout);
            panelMainLayout.setHorizontalGroup(
                panelMainLayout.createParallelGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
            );
            panelMainLayout.setVerticalGroup(
                panelMainLayout.createParallelGroup()
                    .addGap(0, 492, Short.MAX_VALUE)
            );
        }

        //---- labelWait ----
        labelWait.setText("WAIT...");
        labelWait.setForeground(Color.red);
        labelWait.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- labelTime ----
        labelTime.setText("time");
        labelTime.setHorizontalAlignment(SwingConstants.RIGHT);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(labelPrj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelPhase, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
                        .addComponent(panelMain, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(labelWait, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                            .addComponent(labelTime, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelMain, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTime)
                        .addComponent(labelWait))
                    .addGap(1, 1, 1)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPhase)
                        .addComponent(labelPrj))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JMenuBar menuBar1;
    private JMenu menuFile;
    private JMenuItem miNewPrj;
    private JMenuItem miOpenPrj;
    private JMenuItem miForceSavePrj;
    private JMenuItem miPrjProps;
    private JMenuItem miClosePrj;
    private JMenu menuPhase;
    private JMenuItem miPh01;
    private JMenuItem miPh02;
    private JMenuItem miPh03;
    private JMenuItem miPh04;
    private JLabel labelPhase;
    private JLabel labelPrj;
    private JPanel panelMain;
    private JLabel labelWait;
    private JLabel labelTime;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private MainWindow MW;

    private long timeStart = 0;
    private long timeStop = 0;

    public void waitHide() {
        getLabelWait().setFont(new Font("Arial", Font.PLAIN, 14));
        getLabelWait().setForeground(Color.black);
        getLabelWait().setText(" ");
        getLabelWait().update(getLabelWait().getGraphics());

        getLabelTime().setFont(new Font("Arial", Font.PLAIN, 14));
        getLabelTime().setForeground(Color.black);
        getLabelTime().setText(" ");
        getLabelTime().update(getLabelWait().getGraphics());

        MW.repaint();
    }

    public void waitStart() {
        timeStart = System.currentTimeMillis();
        timeStop = System.currentTimeMillis();
        getLabelWait().setFont(new Font("Arial", Font.BOLD, 14));
        getLabelWait().setForeground(Color.red);
        getLabelWait().setText("WAIT...");
        getLabelWait().update(getLabelWait().getGraphics());

        getLabelTime().setFont(new Font("Arial", Font.PLAIN, 14));
        getLabelTime().setForeground(Color.black);
        getLabelTime().setText(" ");
        getLabelTime().update(getLabelWait().getGraphics());

        MW.repaint();
    }

    public void waitStop()  {
        timeStop = System.currentTimeMillis();
        long tdiff = timeStop - timeStart;
        String timeMsg = " ";
        if (tdiff > 0) {
            //timeMsg = "time: " + (double) (tdiff / (double) 1000);
            timeMsg = "time: " + (new SimpleDateFormat("mm:ss:SSS")).format(new Date(tdiff));
        }
        getLabelWait().setFont(new Font("Arial", Font.PLAIN, 14));
        getLabelWait().setForeground(Color.black);
        getLabelWait().setText(" ");
        getLabelWait().update(getLabelWait().getGraphics());

        getLabelTime().setFont(new Font("Arial", Font.PLAIN, 14));
        getLabelTime().setForeground(Color.black);
        getLabelTime().setText(timeMsg);
        getLabelTime().update(getLabelWait().getGraphics());

        MW.repaint();
    }


}
