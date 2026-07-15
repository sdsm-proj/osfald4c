package pl.org.opi.util.showDiff;

import org.apache.commons.lang3.StringUtils;
import pl.org.opi.sdsm.app.vuespringsection.oper.generatePhase.filecomparator.CompareResult;
import pl.org.opi.sdsm.app.vuespringsection.oper.generatePhase.filecomparator.CompareText;
import pl.org.opi.sdsm.frmwk.mechanics.component.JTextPaneNoWrap;

import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.util.List;

public class ShowDiff {

    public enum Mode {
        AB, BC, AC
    }

    private final Mode mode;
    private final boolean showImmediately;
    private final JTextPaneNoWrap textPaneA;
    private final JTextPaneNoWrap textPaneB;
    private final JTextPaneNoWrap textPaneC;
    private final String contentA;
    private final String contentB;
    private final String contentC;

    private JTextPaneNoWrap textPaneL;
    private JTextPaneNoWrap textPaneR;
    private String contentL;
    private String contentR;

    public ShowDiff(Mode mode, boolean showImmediately, JTextPaneNoWrap textPaneA, JTextPaneNoWrap textPaneB, JTextPaneNoWrap textPaneC, String contentA, String contentB, String contentC) {
        this.mode = mode;
        this.showImmediately = showImmediately;
        this.textPaneA = textPaneA;
        this.textPaneB = textPaneB;
        this.textPaneC = textPaneC;

        if (StringUtils.isNotBlank(contentA)) {
            this.contentA = contentA.trim();
        } else {
            this.contentA = "";
        }
        if (StringUtils.isNotBlank(contentB)) {
            this.contentB = contentB.trim();
        } else {
            this.contentB = "";
        }
        if (StringUtils.isNotBlank(contentC)) {
            this.contentC = contentC.trim();
        } else {
            this.contentC = "";
        }

        switch (mode) {
            case AB -> {
                contentL = this.contentA;
                textPaneL = this.textPaneA;
                contentR = this.contentB;
                textPaneR = this.textPaneB;
            }
            case BC -> {
                contentL = this.contentB;
                textPaneL = this.textPaneB;
                contentR = this.contentC;
                textPaneR = this.textPaneC;
            }
            case AC -> {
                contentL = this.contentA;
                textPaneL = this.textPaneA;
                contentR = this.contentC;
                textPaneR = this.textPaneC;
            }
        }
        if (showImmediately) show();
    }

    public void show() {
        clear();
        simpleSet();
        try {
            compare();
        } catch (BadLocationException ex) {
            textPaneA.setText(ex.getMessage());
            textPaneB.setText(ex.getMessage());
            textPaneC.setText(ex.getMessage());
        }
    }

    private void clear() {
        textPaneA.setText("");
        textPaneB.setText("");
        textPaneC.setText("");
    }

    private void simpleSet() {
        textPaneA.setText(contentA);
        textPaneB.setText(contentB);
        textPaneC.setText(contentC);
    }

    private void compare() throws BadLocationException {
        textPaneL.setText("");
        textPaneR.setText("");

        String[] linesL = contentL.split("\\r?\\n|\\r");
        String[] linesR = contentR.split("\\r?\\n|\\r");
        List<String> listL = List.of(linesL);
        List<String> listR = List.of(linesR);

        CompareText compareText = new CompareText();
        CompareResult compareResult = compareText.compare(listL, listR);

        StyledDocument docL = textPaneL.getStyledDocument();
        StyledDocument docR = textPaneR.getStyledDocument();

        Style styleBlack = textPaneL.addStyle("", null);
        Style styleRed = textPaneL.addStyle("", null);

        StyleConstants.setForeground(styleBlack, Color.black);
        StyleConstants.setForeground(styleRed, Color.red);

        for (CompareResult.CompareResultRow row : compareResult.getRows()) {
            Style styleLeft = styleBlack;
            Style styleRight = styleBlack;

            var cmpStatus = row.getCompareStatus();
            switch (cmpStatus) {
                case "CHANGE":
                    styleLeft = styleRed;
                    styleRight = styleRed;
                    break;
                case "DELETE":
                    styleLeft = styleRed;
                    styleRight = styleRed;
                    break;
                case "INSERT":
                    styleLeft = styleRed;
                    styleRight = styleRed;
                    break;
            }

            String lineLeft = row.getLineLeft().getText();
            docL.insertString(docL.getLength(), lineLeft + "\n", styleLeft);

            String lineRight = row.getLineRight().getText();
            docR.insertString(docR.getLength(), lineRight + "\n", styleRight);
        }

    }
}
