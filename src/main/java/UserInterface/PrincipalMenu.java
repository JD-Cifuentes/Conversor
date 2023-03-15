package UserInterface;


import views.CurrencyView;
import views.TempView;
import views.WelcomeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalMenu extends JFrame {
    private JPanel backgoundMain;
    private JPanel menuBanner;
    private JPanel content;
    private JPanel imgContent;
    private JLabel aluraLabel;
    private JButton temperaturaButton;
    private JButton currencyButton;
    private JButton backButton;
    private JButton closeButton;

    WelcomeView pView = new WelcomeView();
    TempView tView = new TempView();
    CurrencyView cView = new CurrencyView();

    public PrincipalMenu() throws HeadlessException {
        changeContent(pView.getWelcomePanel());
        changeContentImg(pView.getWelcomeImgPanel());
        temperaturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeContent(tView.getTempPanel());
                changeContentImg(tView.getTempImgPanel());
            }
        });
        currencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeContent(cView.getCurrencyPanel());
                changeContentImg(cView.getCurrencyImgPanel());
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeContent(pView.getWelcomePanel());
                changeContentImg(pView.getWelcomeImgPanel());
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas cerrar la aplicación?","Cerrar aplicación",JOptionPane.YES_NO_OPTION);
                if(opcion == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }

    public void changeContent(JPanel panel){

        panel.setSize(250,400);
        panel.setMaximumSize(new Dimension(250,400));
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

}
