package UI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu{
    private JPanel Field;
    private JButton addButton;
    private JButton deleteButton;
    public JList NameList;
    public JList CheckList;
    JFrame frame = new JFrame();

    public MainMenu(DefaultListModel<String> listModelName, DefaultListModel<String> listModelCheck) {
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
    }

    public MainMenu() { //НЕ УДАЛЯТЬ, ЭТО МАГИЯ, НО ОНО РАБОТАЕТ !!!!!
    }

    public static void main(String[] args) {
        DefaultListModel<String> listModelName = new DefaultListModel<>();
        DefaultListModel<String> listModeCheck = new DefaultListModel<>();
        JFrame frame = new JFrame();
        frame.setContentPane(new MainMenu(listModelName, listModeCheck).Field);
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}