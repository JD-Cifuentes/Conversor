package com.Conversor.views;

import com.Conversor.Conversors.CurrencyConversorRequest;
import com.Conversor.Utilities.*;

import javax.print.attribute.standard.NumberUp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CurrencyView {
    private JPanel currencyPanel;
    private JPanel CurrencyBG;
    private JPanel currencyImgPanel;
    private JButton currencyConvertBttn;
    private JButton copyCurrencyBtton;
    private JButton apiKeyBttn;
    private JComboBox outCurrencyBox;
    private JComboBox inCurrencyBox;
    private JTextField inCurrencyValue;
    private JTextField outCurrencyValue;
    private JLabel toLabel;
    private JLabel currencyTitle;
    private JLabel fromLabel;
    private JLabel currencyBannerLabel;



    public CurrencyView() {
        new InitComboBoxes(inCurrencyBox, outCurrencyBox, PathsToDataFormats.CURRENCIES);
        try {
            inCurrencyValue.addFocusListener(new InitPlaceHoldersAndFocusListeners(inCurrencyValue, outCurrencyValue));
            inCurrencyValue.addKeyListener(new DoubleOnlyKeyListener(inCurrencyValue));
            currencyConvertBttn.addActionListener(new BttnConversionAction(inCurrencyValue, outCurrencyValue, inCurrencyBox, outCurrencyBox, AvaibleConversions.CURRENCYCONV.toString()));
            copyCurrencyBtton.addActionListener(new BttnCopy(outCurrencyValue));
            apiKeyBttn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String keyApyInput = JOptionPane.showInputDialog(null, "Ingresa la ApyKey generada:", "Ingreso ApyKey personal", JOptionPane.QUESTION_MESSAGE);
                    if(keyApyInput != null){
                        new CurrencyConversorRequest().setApiKey(keyApyInput);
                    }
                }
            });
        }catch (NullPointerException  e){
            System.out.println(e + " at CurrencyView");
        }
    }

    public JPanel getCurrencyPanel() {
        return currencyPanel;
    }

    public JPanel getCurrencyImgPanel() {
        return currencyImgPanel;
    }


}
