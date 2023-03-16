package com;

import com.Conversor.UserInterface.PrincipalMenu;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkFlatIJTheme() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        PrincipalMenu pm = new PrincipalMenu();
        pm.setContentPane(pm.getBackgoundMain());
        pm.setTitle("Conversor Alura");
        pm.pack();
        pm.setResizable(false);
        pm.setVisible(true);
        centreWindow(pm);
        pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}