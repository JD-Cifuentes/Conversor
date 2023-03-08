package views;

import javax.swing.*;

public class welcomeView extends JFrame {
    private JLabel welcomeLabel;
    private JPanel welcomeBG;
    private JLabel welcomeGif;
    private JPanel welcomePanel;
    private JPanel welcomeImgPanel;
    private JLabel oneBannerLabel;

    private final ImageIcon oneLeftBannerExtraction = new ImageIcon("/interfaceimages/Onevertical.png");


    public JPanel getWelcomeContent() {
        return welcomePanel;
    }

    public JPanel getWelcomeImg() {
        return welcomeImgPanel;
    }
}
