package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindow {

    JPanel AddWin;
    private JTextField NameBook;
    private JButton addButton;
    private JCheckBox readCheckBox;
    private JTextField textField1;
    private JButton browseButton;

    public AddWindow() {
        readCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
