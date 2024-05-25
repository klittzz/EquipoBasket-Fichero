package main.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    
    public static File fileWriter(String string, String fileName, int overwrite){
        File file = new File(fileName);
        if(overwrite == 1){
            try (FileWriter fw = new FileWriter(file)) {
                fw.write(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try (FileWriter fw = new FileWriter(file, true)) {
                fw.write("\n" +string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static void fileReader(File file){
        try (FileReader fr = new FileReader(file)){
            int character;
            while ((character = fr.read()) != -1) System.out.print((char) character);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

