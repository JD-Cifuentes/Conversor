import UserInterface.PrincipalMenu;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

import javax.swing.*;


public class Main {


    public static void main(String[] args) {
       //FlatLightLaf.setup();

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


        pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
}