package level2;

import model.DirectoryManager;

import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;

public class Ex1 {

    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("File can't be readed" + e.getMessage());
        }

        String directory = properties.getProperty("directoryPath");
        String outputFile = properties.getProperty("outputFile");
        boolean recursive = Boolean.parseBoolean(properties.getProperty("recursive"));

        DirectoryManager directoryManager = new DirectoryManager();
        directoryManager.setFolderPath(directory);

        boolean result = directoryManager.saveDirectoryTreeToFile(outputFile, recursive);

        if (result) {
            System.out.println("Directory tree saved successfully to " + outputFile);
        } else {
            System.err.println("Failed to save directory tree.");
        }

        System.out.println("[FOLDER]: " + directory);
        System.out.println("[FILE]: " + outputFile);
        System.out.println("Recursive: " + recursive);


    }

}