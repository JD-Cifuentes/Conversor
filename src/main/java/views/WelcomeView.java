package views;

import javax.swing.*;

public class WelcomeView extends JFrame {
    private JLabel welcomeLabel;
    private JPanel welcomeBG;
    private JLabel welcomeGif;
    private JPanel welcomePanel;
    private JPanel welcomeImgPanel;
    private JLabel oneBannerLabel;

    private final ImageIcon oneLeftBannerExtraction = new ImageIcon("/interfaceimages/Onevertical.png");

    public JPanel getWelcomePanel() {
        return welcomePanel;
    }

    public JPanel getWelcomeImgPanel() {
        return welcomeImgPanel;
    }
}
