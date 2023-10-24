package UI;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class MainMenu{
    private JPanel Field;
    private JButton addButton;
    private JButton deleteButton;
    public JList NameList;
    public JList CheckList;
    JFrame frame = new JFrame();

    public MainMenu() { //НЕ УДАЛЯТЬ, ЭТО МАГИЯ, НО ОНО РАБОТАЕТ !!!!!
    }

    public static void main(String[] args) {
        DefaultListModel<String> listModelName = filer("TitleList.txt");
        DefaultListModel<String> listModeCheck = filer("ReadList.txt");
        JFrame frame = new JFrame();
        frame.setContentPane(new MainMenu(listModelName, listModeCheck).Field);
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public MainMenu(DefaultListModel<String> listModelName, DefaultListModel<String> listModelCheck) {
            frame.setContentPane(new AddWindow(listModelName, listModelCheck).AddWin);
            NameList.setModel(listModelName);
            CheckList.setModel(listModelCheck);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new AddWindow(listModelName, listModelCheck).AddWin);
                frame.setSize(400,200);
                frame.setResizable(true);
                frame.setVisible(true);
                NameList.setModel(listModelName);
                CheckList.setModel(listModelCheck);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    static public DefaultListModel<String> filer(String file){
        DefaultListModel<String> listModelName = new DefaultListModel<>();
        try(FileReader reader = new FileReader(file))
        {
            BufferedReader bf = new BufferedReader(reader);
            String line = bf.readLine();
            int heh = 0;
            while (line!=null){
                listModelName.addElement(line);
                line = bf.readLine();
                heh++;
            }
        }
        catch(IOException ex){

            System.out.println("COCK");
            return listModelName;
        }
        return listModelName;
    }
}