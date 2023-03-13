package Utilities;

import Conversors.TempConversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

public class BttnConversionAction implements ActionListener {

    private JTextField inValue;
    private JLabel outValue;
    private JComboBox inComboBox;
    private JComboBox outComboBox;

    public BttnConversionAction(JTextField inValue, JLabel outValue, JComboBox inComboBox, JComboBox outComboBox) {
        this.inValue = inValue;
        this.outValue = outValue;
        this.inComboBox = inComboBox;
        this.outComboBox = outComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inValue.getText().isEmpty() || inValue.getText().equals("Agregar valor")){
            JOptionPane.showMessageDialog(null,"No has ingresado ningún valor.","Falta valor", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ComboBoxKeyValue outBoxOption = (ComboBoxKeyValue) this.outComboBox.getSelectedItem();
                ComboBoxKeyValue inBoxOption = (ComboBoxKeyValue) this.inComboBox.getSelectedItem();

                if ( inBoxOption != outBoxOption){
                    double entryValue = Double.parseDouble(inValue.getText());
                    TempConversor convert = new TempConversor();
                    Class<?> myClass = convert.getClass();
                    String pair =inBoxOption.getSimbol()+"to"+outBoxOption.getSimbol();
                    Method method = myClass.getMethod(pair, double.class);
                    if(outBoxOption.getSimbol().equals("C") || outBoxOption.getSimbol().equals("F")){
                        outValue.setText(String.format("%.2f", method.invoke(convert,entryValue)) + "°" + " " + outBoxOption.getSimbol());
                    } else if (outBoxOption.getSimbol().equals("K")) {
                        outValue.setText(String.format("%.2f", method.invoke(convert,entryValue)) + " " + outBoxOption.getSimbol());
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"Las unidades de entrada y salida son las mismas.","Unidades iguales",JOptionPane.WARNING_MESSAGE);
                }
            }catch (Exception exception){
                System.out.println(exception);
                JOptionPane.showMessageDialog(null,"Valor ingresado no valido, solo se admiten números reales usando coma para el decimal","Valor invalido",JOptionPane.WARNING_MESSAGE);
            }
        }

    }
    
}
