package Utilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BttnConversionAction implements ActionListener {

    private JTextField inValue;
    private JLabel outValue;

    public BttnConversionAction(JTextField inValue, JLabel outValue) {
        this.inValue = inValue;
        this.outValue = outValue;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (inValue.getText().isEmpty() || inValue.getText().equals("Agregar valor")){
            JOptionPane.showMessageDialog(null,"No has ingresado ningún valor.","Falta valor", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                double entryvalue = Double.parseDouble(inValue.getText());
                outValue.setText(String.valueOf(entryvalue*10));
            }catch (Exception exception){
                System.out.println(exception);
                JOptionPane.showMessageDialog(null,"Valor ingresado no valido, solo se admiten números reales usando punto para el decimal","Valor invalido",JOptionPane.WARNING_MESSAGE);
            }
        }

    }
    
}
