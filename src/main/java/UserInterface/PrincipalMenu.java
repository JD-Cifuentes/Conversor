package UserInterface;


import views.tempView;
import views.welcomeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PrincipalMenu extends JFrame {

    private JPanel backgoundMain;
    private JPanel menuBanner;
    private JPanel content;

    private final ImageIcon tempLeftBannerExtraction = new ImageIcon("/interfaceimages/thermometer.png");
    private JLabel aluraLabel;
    private JButton temperaturaButton;
    private JButton lengthButton;
    private JPanel imgContent;
    welcomeView pView = new welcomeView(); //first panel view
    tempView tView = new tempView();




    public PrincipalMenu() throws HeadlessException {

        changeContent(pView.getWelcomeContent());
        changeContentImg(pView.getWelcomeImg());

        temperaturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changeContent(tView.getTempContent());
                changeContentImg(tView.getTempImg());

            }
        });


        lengthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeContent(pView.getWelcomeContent());
                changeContentImg(pView.getWelcomeImg());
            }
        });

    }

    public void changeContent(JPanel panel){

        panel.setSize(250,400);
        panel.setLocation(0,0);

        this.content.removeAll();
        this.content.add(panel,BorderLayout.CENTER);
        this.content.revalidate();
        this.content.repaint();
    }

    public void changeContentImg(JPanel imgPanel){

        imgPanel.setSize(140,400);
        imgPanel.setLocation(0,0);

        this.imgContent.removeAll();
        this.imgContent.add(imgPanel,BorderLayout.CENTER);
        this.imgContent.revalidate();
        this.imgContent.repaint();
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
