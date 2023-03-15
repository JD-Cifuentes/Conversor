package Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BttnCopy implements ActionListener {
    private final JTextField OutputToCopy;

    public BttnCopy(JTextField outputToCopy) {
        OutputToCopy = outputToCopy;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        StringSelection outputCopied = new StringSelection(this.OutputToCopy.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(outputCopied,null);
    }
}
