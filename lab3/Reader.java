package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Reader {
    public static ArrayList<String> read() {
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader reader = null;
        try {
           reader = new BufferedReader(new FileReader("D:\\myproject\\oop\\Minesweeper\\src\\main\\java\\lab3\\resources\\ranking.csv"));
            String currLine;
            while ((currLine = reader.readLine()) != null)
                lines.add(currLine);
        }
        catch(IOException e) {
            System.out.println("Error while reading file " + e.getLocalizedMessage());
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return lines;
    }
}