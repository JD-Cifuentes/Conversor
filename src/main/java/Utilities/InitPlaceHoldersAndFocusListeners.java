package Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class InitPlaceHoldersAndFocusListeners implements FocusListener {
    private JTextField inValue;
    private JTextField outValue;
    public InitPlaceHoldersAndFocusListeners(JTextField inValue, JTextField outValue) {
        this.inValue = inValue;
        this.outValue = outValue;
        this.outValue.setForeground(Color.lightGray);
        this.outValue.setText("Resultado");
        this.outValue.setFont(new Font("Roboto Light",100,12));
        this.inValue.setText("Agregar valor");

    }
        public void focusGained(FocusEvent e) {
            if (inValue.getText().equals("Agregar valor")) {
                inValue.setText("");
            }
        }
        public void focusLost(FocusEvent e) {
            if (inValue.getText().isEmpty()) {
                inValue.setText("Agregar valor");
            }
        }


}
