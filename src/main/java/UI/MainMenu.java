package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static UI.AddWindow.*;

public class MainMenu{
    private JPanel Field;
    private JButton addButton;
    private JButton deleteButton;
    public JList NameList;
    public JList CheckList;
    private JButton Read;
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
                if(!(NameList.isSelectionEmpty())) {
                    int kek = NameList.getSelectedIndex();
                    listModelName.remove(kek);
                    listModelCheck.remove(kek);
                    NameList.setModel(listModelName);
                    CheckList.setModel(listModelCheck);
                    deleter(kek, pathlist);
                    deleter(kek, titleList);
                    deleter(kek, readList);

                }
                else if(!(CheckList.isSelectionEmpty())) {
                    int kek = CheckList.getSelectedIndex();
                    listModelName.remove(kek);
                    listModelCheck.remove(kek);
                    NameList.setModel(listModelName);
                    CheckList.setModel(listModelCheck);
                }
                else {
                    System.out.println("kek");
                    return;
                }
            }
        });
        Read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = NameList.getSelectedIndex();
                String path;
                try {
                    path = Files.readAllLines(Paths.get(pathlist)).get(id);
                    File file = new File(path);
                    Desktop desktop = Desktop.getDesktop();
                    if(file.exists()) {
                        try {
                            desktop.open(file);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    static public DefaultListModel<String> filer(String file){
        DefaultListModel<String> listModelName = new DefaultListModel<>();
        try(FileReader reader = new FileReader(file))
        {
            BufferedReader bf = new BufferedReader(reader);
            String line = bf.readLine();
            while (line!=null){
                listModelName.addElement(line);
                line = bf.readLine();
            }
        }
        catch(IOException ex){
            System.out.println("Nope");
            return listModelName;
        }
        return listModelName;
    }
    public void deleter(int index, String file){
        File inputFile = new File(file);
        File tempFile = new File("myTempFile.txt");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            int incr = 0;
            while((currentLine = br.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if(incr == index) {incr++; continue;}
                bw.write(currentLine + System.getProperty("line.separator"));
                incr++;
            }
            bw.close();
            br.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}