package UI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

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
                if (bookName.equals("") || bookName.equalsIgnoreCase("enter book name")) {
                    NameBook.setText("enter book name");
                } else {
                    String read = "Read";
                    String unread = "Unread";
                    String ru;
                    if (readCheckBox.isSelected()) {
                        listModelCheck.addElement(read);
                        CheckList.setModel(listModelCheck);
                        ru = read;
                    } else {
                        listModelCheck.addElement(unread);
                        CheckList.setModel(listModelCheck);
                        ru = unread;
                    }
                    listModelName.addElement(bookName);
                    NameList.setModel(listModelName);


                    try {
                        File file = new File("TitleList.txt");
                        if(!file.exists()){
                            file.createNewFile();
                        }
                        FileWriter writer = new FileWriter(file,true);
                        writer.write(bookName+"\n");
                        writer.close();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                    try {
                        File file = new File("ReadList.txt");
                        if(!file.exists()){
                            file.createNewFile();
                        }
                        FileWriter writer = new FileWriter(file, true);
                        writer.write(ru+"\n");
                        writer.close();
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
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
