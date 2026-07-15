package pl.org.opi.sdsm.frmwk.mechanics.component;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class JTextPaneNoWrap extends JTextPane {

    public JTextPaneNoWrap() {
    }

    public JTextPaneNoWrap(StyledDocument doc) {
        super(doc);
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
//        return false;
        return getUI().getPreferredSize(this).width
                <= getParent().getSize().width;
    }

    @Override
    public Dimension getPreferredSize() {
        // Avoid substituting the minimum width for the preferred width when the viewport is too narrow
        return getUI().getPreferredSize(this);
    };

}
