import UserInterface.PrincipalMenu;
import Utilities.ComboBoxKeyValue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.Map;


public class Main {



    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel( new FlatDarkFlatIJTheme() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        PrincipalMenu pm = new PrincipalMenu();

        pm.setContentPane(pm.getBackgoundMain());
        pm.setTitle("Tittle");
        pm.setSize(600, 435);
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