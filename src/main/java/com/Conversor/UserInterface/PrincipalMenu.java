package com.Conversor.UserInterface;


import com.Conversor.views.CurrencyView;
import com.Conversor.views.TempView;
import com.Conversor.views.WelcomeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
    private JButton linkedinBttn;
    private JButton guthubBttn;

    WelcomeView wView = new WelcomeView();
    TempView tView = new TempView();
    CurrencyView cView = new CurrencyView();

    public PrincipalMenu() {
            changeContent(this.wView.getWelcomePanel());
            changeContentImg(this.wView.getWelcomeImgPanel());
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
                    changeContent(wView.getWelcomePanel());
                    changeContentImg(wView.getWelcomeImgPanel());
                }
            });
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int option = JOptionPane.showConfirmDialog(null, "¿Deseas cerrar la aplicación?","Cerrar aplicación",JOptionPane.YES_NO_OPTION);
                    if(option == JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                }
            });

        linkedinBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/juandavidcifuentesflorez/"));
                }catch (IOException | URISyntaxException ex){
                    System.out.println(ex);
                }
            }
        });
        guthubBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/JD-Cifuentes"));
                }catch (IOException | URISyntaxException ex){
                    System.out.println(ex);
                }
            }
        });
    }

    public void changeContent(JPanel panel){

        try{
            panel.setSize(250,400);
            panel.setMaximumSize(new Dimension(250,400));
            panel.setLocation(0,0);
            this.content.removeAll();
            this.content.add(panel,BorderLayout.CENTER);
            this.content.revalidate();
            this.content.repaint();
        }catch (NullPointerException e){
            System.out.println(e + " at PrincipalMenu - changeContent");
        }

    }

    public void changeContentImg(JPanel imgPanel){
        try{
            imgPanel.setSize(140,400);
            imgPanel.setLocation(0,0);
            this.imgContent.removeAll();
            this.imgContent.add(imgPanel,BorderLayout.CENTER);
            this.imgContent.revalidate();
            this.imgContent.repaint();
        }catch (NullPointerException e){
            System.out.println(e + " at PrincipalMenu - changeContentImg");
        }

    }

    public JPanel getBackgoundMain() {
        return backgoundMain;
    }

}
