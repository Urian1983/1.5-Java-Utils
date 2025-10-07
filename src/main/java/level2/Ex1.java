package level2;

import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;

public class Ex1 {

    public static void main(String[] args) {
        Properties properties = new Properties();

        try(FileInputStream fileInputStream = new FileInputStream("config.properties")){
            properties.load(fileInputStream);
        }
        catch(IOException e){
            System.err.println("File can't be readed" + e.getMessage());
        }

        String directory = properties.getProperty("directoryPath");
        String file = properties.getProperty("outputFile");
        boolean recursive = Boolean.parseBoolean(properties.getProperty("recursive"));

        System.out.println("[FOLDER]: " + directory);
        System.out.println("[FILE]: " + file);
        System.out.println("Recursive: " + recursive);


    }
}
