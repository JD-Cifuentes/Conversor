package views;

import Utilities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CurrencyView {
    private JPanel currencyPanel;
    private JButton currencyConvertBttn;
    private JLabel toLabel;
    private JLabel outCurrencyValue;
    private JComboBox outCurrencyBox;
    private JComboBox inCurrencyBox;
    private JTextField inCurrencyValue;
    private JLabel currencyTitle;
    private JLabel fromLabel;
    private JPanel currencyImgPanel;
    private JLabel currencyBannerLabel;
    private JPanel CurrencyBG;


    public CurrencyView() {

        new InitComboBoxes(inCurrencyBox, outCurrencyBox, PathsToDataFormats.CURRENCIES);
        inCurrencyValue.addFocusListener(new InitPlaceHoldersAndFocusListeners(inCurrencyValue, outCurrencyValue));
        inCurrencyValue.addKeyListener(new DoubleOnlyKeyListener(inCurrencyValue));
        currencyConvertBttn.addActionListener(new ConversionAction(inCurrencyValue, outCurrencyValue));
        //initPlaceHolders();
    }

/*    public void initPlaceHolders(){

        this.outCurrencyValue.setForeground(Color.lightGray);
        this.outCurrencyValue.setText("Resultado");
        this.outCurrencyValue.setFont(new Font("Roboto Light",100,12));
        this.inCurrencyValue.setText("Agregar valor");
        inCurrencyValue.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inCurrencyValue.getText().equals("Agregar valor")) {
                    inCurrencyValue.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (inCurrencyValue.getText().isEmpty()) {
                    inCurrencyValue.setText("Agregar valor");
                }
            }
        });



    }*/


    public JPanel getCurrencyPanel() {
        return currencyPanel;
    }

    public JPanel getCurrencyImgPanel() {
        return currencyImgPanel;
    }


}
