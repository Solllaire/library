package UI;

import org.w3c.dom.NameList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddWindow extends MainMenu{

    JPanel AddWin;
    private JTextField NameBook;
    private JButton addButton;
    private JCheckBox readCheckBox;
    private JTextField pathTextField;
    private JButton browseButton;



    DefaultListModel<String> listModelCheck;
    DefaultListModel<String> listModelName;


    public AddWindow() {
        listModelCheck = new DefaultListModel<>();
        listModelName = new DefaultListModel<>();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = NameBook.getText();
                String read = "Read";
                String unread = "Unread";
                if (readCheckBox.isSelected()){

                    listModelCheck.addElement(read);
                    CheckList.setModel(listModelCheck);
                }else {
                    listModelCheck.addElement(unread);
                    CheckList.setModel(listModelCheck);
                }
                listModelName.addElement(bookName);
                NameList.setModel(listModelName);
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