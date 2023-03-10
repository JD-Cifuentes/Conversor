package views;

import Utilities.ComboBoxKeyValue;
import Utilities.ConversionAction;
import Utilities.DoubleOnlyKeyListener;
import Utilities.InitPlaceHoldersAndFocusListeners;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


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
        initComboBoxes();
        inTempValue.addFocusListener(new InitPlaceHoldersAndFocusListeners(inTempValue, outTempValue));
        inTempValue.addKeyListener(new DoubleOnlyKeyListener(inTempValue, "AdmitAllRealNum"));
        tempConvertBttn.addActionListener(new ConversionAction(inTempValue, outTempValue));

    }


    public void initComboBoxes(){
        File tempUnits = new File("src/main/resources/DataFormat/TempFormat.json");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            java.util.List<ComboBoxKeyValue> jsonTempMap = objectMapper.readValue(tempUnits, new TypeReference<List<ComboBoxKeyValue>>(){});
            for (ComboBoxKeyValue entry : jsonTempMap) {
                inTempBox.addItem(entry);
                outTempBox.addItem(entry);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public JPanel getTempPanel() {
        return tempPanel;
    }

    public JPanel getTempImgPanel() {
        return tempImgPanel;
    }

}
