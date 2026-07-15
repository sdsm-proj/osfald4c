package pl.org.opi.sdsm.frmwk.mechanics.component;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JTextAreaNoTab extends JTextArea implements KeyListener {

    public JTextAreaNoTab() {
        super();
        initialize();
    }

    private void initialize() {
        addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_TAB:
                e.consume();
                transferFocus();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_TAB:
                System.out.println("KEY RELEASED TAB");
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_TAB:
                System.out.println("KEY TYPED TAB");
                break;
        }
    }

}
