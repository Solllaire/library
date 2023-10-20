package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddWindow {

    JPanel AddWin;
    private JTextField NameBook;
    private JButton addButton;
    private JCheckBox readCheckBox;
    private JTextField pathTextField;
    private JButton browseButton;
    JFrame frame = new JFrame();
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
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int response=fileChooser.showOpenDialog(null);
                if(response == JFileChooser.APPROVE_OPTION){
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                    pathTextField.setText(file.getAbsolutePath());
                }
            }
        });
    }
}
