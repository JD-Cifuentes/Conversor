package com.Conversor.Utilities;

import javax.print.attribute.standard.NumberUp;
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

        try {
            this.outValue.setForeground(Color.lightGray);
            this.outValue.setText("Resultado");
            this.outValue.setFont(new Font("Roboto Light",100,12));
            this.inValue.setText("Agregar valor");
        }catch (NullPointerException e){
            System.out.println(e + " at InitPlaceHoldersAndFocusListeners");
        }

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
