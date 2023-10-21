package UI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddWindow extends MainMenu{
    JPanel AddWin;
    private JTextField NameBook;
    private JButton addBookButton;
    private JCheckBox readCheckBox;
    private JTextField pathTextField;
    private JButton browseButton;

    DefaultListModel<String> listModelCheck;
    DefaultListModel<String> listModelName;

    public AddWindow(DefaultListModel<String> listModelName, DefaultListModel<String> listModelCheck) {
        this.listModelName = listModelName;
        this.listModelCheck = listModelCheck;

        addBookButton.addActionListener(new ActionListener() {
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
