package Utilities;

import Conversors.TempConversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BttnConversionAction implements ActionListener {

    private final JTextField inValue;
    private final JLabel outValue;
    private final JComboBox inComboBox;
    private final JComboBox outComboBox;
    private double entryValue;
    private final String kindOfConversion;
    private ComboBoxKeyValue inBoxOption;
    private ComboBoxKeyValue outBoxOption;
    private final Map<String, Runnable> conversionMethodSet = new HashMap<>();

    public BttnConversionAction(JTextField inValue, JLabel outValue, JComboBox inComboBox, JComboBox outComboBox, String kindOfConversion) {
        this.inValue = inValue;
        this.outValue = outValue;
        this.inComboBox = inComboBox;
        this.outComboBox = outComboBox;
        this.kindOfConversion = kindOfConversion;

        conversionMethodSet.put(AvaibleConversions.TEMPCONV.toString(), this::toTempConversion);
        conversionMethodSet.put(AvaibleConversions.CURRENCYCONV.toString(), this::toCurrConversion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inValue.getText().isEmpty() || inValue.getText().equals("Agregar valor")){
            JOptionPane.showMessageDialog(null,"No has ingresado ningún valor.","Falta valor", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if ( this.inComboBox.getSelectedItem() != this.outComboBox.getSelectedItem()){

                    this.entryValue = Double.parseDouble(this.inValue.getText());
                    this.inBoxOption = (ComboBoxKeyValue) this.inComboBox.getSelectedItem();
                    this.outBoxOption = (ComboBoxKeyValue) this.outComboBox.getSelectedItem();
                    conversionMethodSet.get(this.kindOfConversion).run();

                }else{
                    JOptionPane.showMessageDialog(null,"Las unidades de entrada y salida son las mismas.","Unidades iguales",JOptionPane.WARNING_MESSAGE);
                }
            }catch (Exception exception){
                System.out.println(exception);
                JOptionPane.showMessageDialog(null,"Valor ingresado no valido, solo se admiten números reales usando coma para el decimal","Valor invalido",JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    public void toTempConversion (){
        TempConversor convert = new TempConversor();
        Class<?> myClass = convert.getClass();
        String pair = inBoxOption.getSimbol() + "to" + outBoxOption.getSimbol();
        Method method;
        try {
            method = myClass.getMethod(pair, double.class);
            if(outBoxOption.getSimbol().equals("C") || outBoxOption.getSimbol().equals("F")){
                outValue.setText(String.format("%.2f", method.invoke(convert,entryValue)) + "°" + " " + outBoxOption.getSimbol());
            } else if (outBoxOption.getSimbol().equals("K")) {
                outValue.setText(String.format("%.2f", method.invoke(convert,entryValue)) + " " + outBoxOption.getSimbol());
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public void toCurrConversion(){


    }
    
}
