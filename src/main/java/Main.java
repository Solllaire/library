import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Practice.OP9_WinDC\\Desktop\\Gall.epub");
            EpubReader epubReader = new EpubReader();
        Book book;
        try {
            book = epubReader.readEpub(new FileInputStream(file));
            List titles = book.getMetadata().getTitles();
        } catch (IOException e) {
            System.out.println("poshel nahui pidaras");
        }
    }
}