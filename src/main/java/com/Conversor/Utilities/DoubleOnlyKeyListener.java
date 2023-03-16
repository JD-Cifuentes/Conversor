package com.Conversor.Utilities;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DoubleOnlyKeyListener implements KeyListener {
    private JTextField textFieldContent;
    private String filter = "";
    public DoubleOnlyKeyListener(JTextField textFieldContent, String filter) {
        this.textFieldContent = textFieldContent;
        this.filter = filter;
    }

    public DoubleOnlyKeyListener(JTextField textFieldContent) {
        this.textFieldContent = textFieldContent;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!isValidCharacter(c)) {

            e.consume();
        }
    }
    private boolean isValidCharacter(char c) {
        if (Character.isDigit(c)) {
            return true;
        } else if (c == '.' && !this.textFieldContent.getText().contains(".") && !this.textFieldContent.getText().isEmpty()) {
            return true;
        } else if (c == '-' && this.textFieldContent.getText().isEmpty() && filter.equals("AdmitAllRealNum")) {
            return true;
        }
        return false;
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
