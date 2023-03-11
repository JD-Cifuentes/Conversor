package views;

import Utilities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CurrencyView {
    private JPanel currencyPanel;
    private JPanel CurrencyBG;
    private JPanel currencyImgPanel;
    private JButton currencyConvertBttn;
    private JComboBox outCurrencyBox;
    private JComboBox inCurrencyBox;
    private JTextField inCurrencyValue;
    private JLabel toLabel;
    private JLabel outCurrencyValue;
    private JLabel currencyTitle;
    private JLabel fromLabel;
    private JLabel currencyBannerLabel;



    public CurrencyView() {
        //inCurrencyBox.setMaximumSize(new Dimension(110,26));
        //outCurrencyBox.setMaximumSize(new Dimension(110,26));
        new InitComboBoxes(inCurrencyBox, outCurrencyBox, PathsToDataFormats.CURRENCIES);
        inCurrencyValue.addFocusListener(new InitPlaceHoldersAndFocusListeners(inCurrencyValue, outCurrencyValue));
        inCurrencyValue.addKeyListener(new DoubleOnlyKeyListener(inCurrencyValue));
        currencyConvertBttn.addActionListener(new ConversionAction(inCurrencyValue, outCurrencyValue));

    }

    public JPanel getCurrencyPanel() {
        return currencyPanel;
    }

    public JPanel getCurrencyImgPanel() {
        return currencyImgPanel;
    }


}
