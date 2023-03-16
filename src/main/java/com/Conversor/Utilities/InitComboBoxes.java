package com.Conversor.Utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InitComboBoxes {
    private JComboBox inBox;
    private JComboBox outBox;
    private InputStream path;

    public InitComboBoxes(JComboBox inBox, JComboBox outBox, PathsToDataFormats PATH) {
        this.inBox = inBox;
        this.outBox = outBox;
        this.path = getClass().getClassLoader().getResourceAsStream(PATH.getPath());
        ObjectMapper objectMapper = new ObjectMapper();
        //File filePath = new File();

        try {
            List<ComboBoxKeyValue> jsonTempMap = objectMapper.readValue(path, new TypeReference<List<ComboBoxKeyValue>>(){});
                for (ComboBoxKeyValue entry : jsonTempMap) {
                    this.inBox.addItem(entry);
                    this.outBox.addItem(entry);
                }
        } catch (NullPointerException | IOException e) {
            System.out.println(e.getCause() + " at InitComboBoxes");
        }

    }


}
