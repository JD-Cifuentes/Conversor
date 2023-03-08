package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
        initPlaceHolders();
    }

    public void initPlaceHolders(){
        this.outTempValue.setForeground(Color.lightGray);
        this.outTempValue.setText("Resultado");
        this.outTempValue.setFont(new Font("Roboto Light",100,12));
        this.inTempValue.setText("Agregar valor");
        inTempValue.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inTempValue.getText().equals("Agregar valor")) {
                    inTempValue.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (inTempValue.getText().isEmpty()) {
                    inTempValue.setText("Agregar valor");
                }
            }
        });

    }


    public JPanel getTempPanel() {
        return tempPanel;
    }

    public JPanel getTempImgPanel() {
        return tempImgPanel;
    }
}
