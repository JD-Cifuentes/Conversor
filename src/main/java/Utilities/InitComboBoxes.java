package Utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class InitComboBoxes {
    private JComboBox inBox;
    private JComboBox outBox;
    private PathsToDataFormats PATH;

    public InitComboBoxes(JComboBox inBox, JComboBox outBox, PathsToDataFormats PATH) {
        this.inBox = inBox;
        this.outBox = outBox;
        this.PATH= PATH;
        ObjectMapper objectMapper = new ObjectMapper();
        File filePath = new File(PATH.getPath());

        try {
            List<ComboBoxKeyValue> jsonTempMap = objectMapper.readValue(filePath, new TypeReference<List<ComboBoxKeyValue>>(){});
            for (ComboBoxKeyValue entry : jsonTempMap) {
                inBox.addItem(entry);
                outBox.addItem(entry);
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }


}
