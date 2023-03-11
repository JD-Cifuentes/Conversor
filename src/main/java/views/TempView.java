package views;

import Utilities.*;
import javax.swing.*;

public class TempView {
    private JPanel tempBG;
    private JTextField inTempValue;
    private JLabel outTempValue;
    private JPanel tempPanel;
    private JButton tempConvertBttn;
    private JLabel toLabel;
    private JComboBox outTempBox;
    private JComboBox inTempBox;
    private JLabel tempTitle;
    private JLabel fromLabel;
    private JLabel tempBannerLabel;
    private JPanel tempImgPanel;

    public TempView() {
        new InitComboBoxes(inTempBox, outTempBox, PathsToDataFormats.TEMP);
        inTempValue.addFocusListener(new InitPlaceHoldersAndFocusListeners(inTempValue, outTempValue));
        inTempValue.addKeyListener(new DoubleOnlyKeyListener(inTempValue, "AdmitAllRealNum"));
        tempConvertBttn.addActionListener(new BttnConversionAction(inTempValue, outTempValue));
    }

    public JPanel getTempPanel() {
        return tempPanel;
    }

    public JPanel getTempImgPanel() {
        return tempImgPanel;
    }

}
