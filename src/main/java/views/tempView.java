package views;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class tempView {
    private JPanel tempBG;
    private JTextField inTempValue;
    private JLabel outTempValue;
    private JPanel tempPanel;
    private JButton tempConvertBttn;
    private JLabel toLabel;
    private JComboBox outTempBox;
    private JComboBox inTempBox;
    private JLabel temptitle;
    private JLabel fromLabel;
    private JLabel TempBannerLabel;
    private JPanel tempImgPanel;

    public tempView() {
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


    public JPanel getTempContent() {
        return tempPanel;
    }

    public JPanel getTempImg() {
        return tempImgPanel;
    }
}
