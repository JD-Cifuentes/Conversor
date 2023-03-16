package com.Conversor.views;

import com.Conversor.Utilities.*;

import javax.print.attribute.standard.NumberUp;
import javax.swing.*;
import java.io.FileNotFoundException;

public class CurrencyView {
    private JPanel currencyPanel;
    private JPanel CurrencyBG;
    private JPanel currencyImgPanel;
    private JButton currencyConvertBttn;
    private JButton copyCurrencyBtton;
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
        }catch (NullPointerException e){
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
