package UserInterface;


import javax.swing.*;
import java.awt.*;

public class PrincipalMenu extends JFrame {

    private JPanel backgoundMain;
    private final ImageIcon oneLeftBannerExtraction = new ImageIcon("/interfaceimages/Onevertical.png");
    private JLabel leftBanner = new JLabel(oneLeftBannerExtraction);
    private JPanel contentPpalMenu;
    private JPanel menuBanner;

    private JPanel welcomePanel;
    private JButton temperaturaButton;
    private JLabel aluraLabel;
    private JLabel gifWelcomLabel;
    private JLabel WelcomeLabel;
    private JButton divisasButton;



    public PrincipalMenu() throws HeadlessException {


    }

    public JPanel getBackgoundMain() {
        return backgoundMain;
    }

    public void setLayout(){

    }

    public void setBackgoundMain(JPanel backgoundMain) {
        this.backgoundMain = backgoundMain;
    }



}
