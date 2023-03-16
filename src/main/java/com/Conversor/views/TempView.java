package com.Conversor.views;

import com.Conversor.Utilities.*;

import javax.swing.*;

public class TempView {
    private JPanel tempBG;
    private JPanel tempPanel;
    private JPanel tempImgPanel;
    private JButton tempConvertBttn;
    private JButton copyTempBttn;
    private JComboBox outTempBox;
    private JComboBox inTempBox;
    private JTextField inTempValue;
    private JTextField outTempValue;
    private JLabel toLabel;
    private JLabel tempTitle;
    private JLabel fromLabel;
    private JLabel tempBannerLabel;


    public TempView() {
        new InitComboBoxes(inTempBox, outTempBox, PathsToDataFormats.TEMP);
        try {
            inTempValue.addFocusListener(new InitPlaceHoldersAndFocusListeners(inTempValue, outTempValue));
            inTempValue.addKeyListener(new DoubleOnlyKeyListener(inTempValue, "AdmitAllRealNum"));
            tempConvertBttn.addActionListener(new BttnConversionAction(inTempValue, outTempValue, inTempBox, outTempBox, AvaibleConversions.TEMPCONV.toString()));
            copyTempBttn.addActionListener(new BttnCopy(outTempValue));
        }catch (NullPointerException e){
            System.out.println(e + " at TempView");
        }


    }

    public JPanel getTempPanel() {
        return tempPanel;
    }

    public JPanel getTempImgPanel() {
        return tempImgPanel;
    }

}
