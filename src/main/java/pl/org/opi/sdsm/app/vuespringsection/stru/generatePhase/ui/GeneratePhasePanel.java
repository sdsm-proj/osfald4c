/*
 * Created by JFormDesigner on Sun Oct 27 14:16:07 CET 2024
 */

package pl.org.opi.sdsm.app.vuespringsection.stru.generatePhase.ui;

import java.awt.*;

import pl.org.opi.sdsm.app.vuespringsection.oper.generatePhase.filecomparator.CompareText;
import pl.org.opi.sdsm.frmwk.mechanics.component.JTextPaneNoWrap;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * @author abochenek
 */
public class GeneratePhasePanel extends JPanel {
    public GeneratePhasePanel() {
        initComponents();
    }

    private void onBtnOper1(ActionEvent e) {
        doOper1();
    }

    private void button1(ActionEvent e) {

        StyledDocument doc1 = textPane1.getStyledDocument();
        StyledDocument doc2 = textPane2.getStyledDocument();

        Style style = textPane1.addStyle("I'm a Style", null);


        for (int i = 0; i < 1000; i++) {
            StyleConstants.setForeground(style, Color.red);
            try {
                doc1.insertString(doc1.getLength(), "BLAH aaaaaaaaaaaa aaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaaaaa aaaaaaaaaaaaaaaa\n", style);
                doc2.insertString(doc2.getLength(), "BLAH aaaaaaaaaaaa \n", style);
            } catch (BadLocationException ex) {
            }
            StyleConstants.setForeground(style, Color.blue);
            try {
                doc1.insertString(doc1.getLength(), "BLEH aaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n", style);
                doc2.insertString(doc2.getLength(), "BLAH aaaaaaaaaaaa \n", style);
            } catch (BadLocationException ex) {
            }
        }

        textPane1.setCaretPosition(0);
        textPane1.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        textPane2.setCaretPosition(0);
        textPane2.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        AdjustmentListener adjustmentListener = new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int vPos = scrollPane1.getVerticalScrollBar().getValue();

                scrollPane2.getVerticalScrollBar().setValue(vPos);

            }
        };

        scrollPane1.getVerticalScrollBar().addAdjustmentListener(
                adjustmentListener);
        scrollPane1.getHorizontalScrollBar().addAdjustmentListener(
                adjustmentListener);


    }

    private void splitPane1ComponentResized(ComponentEvent e) {
        splitPane1.setDividerLocation(splitPane1.getWidth() / 2);
    }

    private void splitPane1ComponentShown(ComponentEvent e) {
        splitPane1.setDividerLocation(splitPane1.getWidth() / 2);
    }

//        textPane1 = new JTextPane()
//        {
//            public boolean getScrollableTracksViewportWidth()
//            {
//                //return false;
//                return getUI().getPreferredSize(this).width
//                        <= getParent().getSize().width;
//            }
//        };

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        btnOper1 = new JButton();
        button1 = new JButton();
        splitPane1 = new JSplitPane();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPaneNoWrap();
        scrollPane2 = new JScrollPane();
        textPane2 = new JTextPaneNoWrap();

        //======== this ========
        setPreferredSize(new Dimension(50, 50));

        //---- label2 ----
        label2.setText("text");

        //---- label3 ----
        label3.setText("text");

        //---- label4 ----
        label4.setText("text");

        //---- btnOper1 ----
        btnOper1.setText("Oper 1");
        btnOper1.addActionListener(e -> onBtnOper1(e));

        //---- button1 ----
        button1.setText("text");
        button1.addActionListener(e -> button1(e));

        //======== splitPane1 ========
        {
            splitPane1.setDividerSize(14);
            splitPane1.setDividerLocation(200);
            splitPane1.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    splitPane1ComponentResized(e);
                }
                @Override
                public void componentShown(ComponentEvent e) {
                    splitPane1ComponentShown(e);
                }
            });

            //======== scrollPane1 ========
            {
                scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane1.setViewportView(textPane1);
            }
            splitPane1.setLeftComponent(scrollPane1);

            //======== scrollPane2 ========
            {
                scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane2.setViewportView(textPane2);
            }
            splitPane1.setRightComponent(scrollPane2);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 843, Short.MAX_VALUE)
                            .addComponent(label4))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnOper1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 701, Short.MAX_VALUE)
                            .addComponent(label2)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOper1)
                            .addComponent(button1)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(splitPane1, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(label4))
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton btnOper1;
    private JButton button1;
    private JSplitPane splitPane1;
    private JScrollPane scrollPane1;
    private JTextPaneNoWrap textPane1;
    private JScrollPane scrollPane2;
    private JTextPaneNoWrap textPane2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void doOper1() {
        List<String> before = new ArrayList<>();
        List<String> after = new ArrayList<>();

        before.add("a");
        before.add("a");
        before.add("a");

        after.add("a");
        after.add("a");
        after.add("b1");
        after.add("b2");
        after.add("b3");
        after.add("a");

        CompareText compareText = new CompareText();
        compareText.compare(before, after);

        int dbg1 = 1;
    }

}
