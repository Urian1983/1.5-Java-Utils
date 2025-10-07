package model;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DirectoryManager implements Serializable {
    private String folderPath = "newFolder";
    private File folder;

    public DirectoryManager(){
        this.folderPath = "newFolder";
        this.folder = new File(folderPath);
    }

    public File[] showDirectory() {
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("The folder does not exist or is not a directory.");
            return null;
        }

        File[] contentDirectory = folder.listFiles();
        if (contentDirectory == null || contentDirectory.length == 0) {
            System.out.println("The content of the directory is empty");
            return contentDirectory;
        }
        alphabeticOrderSort(contentDirectory);
        return contentDirectory;
    }

    public void printDirectoryContents(File[] contentDirectory){
        if(contentDirectory == null || contentDirectory.length ==0){
            System.out.println("The directory is empty");
            return;
        }

        alphabeticOrderSort(contentDirectory);

        System.out.println("Contents of the directory:");
        for (int j = 0; j < contentDirectory.length; j++) {
            File item = contentDirectory[j];
            if (item.isDirectory()) {
                System.out.println("[DIR] " + item.getName());
            } else if (item.isFile()) {
                System.out.println("[FILE] " + item.getName());
            } else {
                System.out.println("[?] " + item.getName());
            }
        }
    }

    public void printDirectoryDetailed(boolean recursive){
        if(!folder.exists() || !folder.isDirectory()){
            System.out.println("The folder does not exist or is not a directory");
            return;
        }

        System.out.println("Contents of: " + folder.getPath());
        printDirectoryDetailedRecursive(folder, "",recursive);

    }

    private void printDirectoryDetailedRecursive(File directory, String indent,boolean recursive){
        File[] contents = directory.listFiles();

        if (contents == null || contents.length==0){
            System.out.println(indent + "empty");
            return;
        }

        alphabeticOrderSort(contents);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH/mm/ss");

        for (File item: contents){
            String type = item.isDirectory() ? "[FOLDER] " : "[FILE] ";
            String lastModified =sdf.format(item.lastModified());
            System.out.println(indent + type + " " + item.getName() + " Last modified:" +lastModified);

            if (recursive && item.isDirectory()){
                printDirectoryDetailedRecursive(item, indent + " ", true);
            }
        }
    }

    private void saveDirectoryTreeRecursive(File directory, String indent, boolean recursive, BufferedWriter writer) throws IOException {
        File[] contents = directory.listFiles();
        if (contents == null || contents.length == 0) {
            writer.write(indent + "[empty]");
            writer.newLine();
            return;
        }

        alphabeticOrderSort(contents);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        for (File item : contents) {
            String type = item.isDirectory() ? "(D)" : "(F)";
            String lastModified = sdf.format(item.lastModified());
            writer.write(indent + type + " " + item.getName() + " — Last modified: " + lastModified);
            writer.newLine();

            // Si es carpeta y recursive es true → entrar en ella
            if (recursive && item.isDirectory()) {
                saveDirectoryTreeRecursive(item, indent + "   ", true, writer);
            }
        }
    }

    public boolean saveDirectoryTreeToFile(String outPutFile, boolean recursive) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outPutFile))) {
            writer.write("Directory tree for: " + folder.getPath());
            writer.newLine();
            saveDirectoryTreeRecursive(folder, "", recursive, writer);
            System.out.println("Directory tree saved to: " + outPutFile);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
            return false;
        }
    }

    public boolean createNewFolder(String newFolderName) {
        try {

            File newFolder = new File(newFolderName);

            if (newFolder.exists() && newFolder.isDirectory()) {
                System.out.println("The folder already exists, choose another one");
                return false;
            } else {
                newFolder.mkdir();
                this.folder = newFolder;
                this.folderPath = newFolder.getPath();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Unable to create a new Folder: " + e.getMessage());
            return false;
        }
    }

    public File getFolder() {
        return folder;
    }
    public String getFolderFilePath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
        this.folder = new File(folderPath);
    }

    private void alphabeticOrderSort (File[] contentDirectory) {
        for (int i = 0; i < contentDirectory.length - 1; i++) {
            for (int j = i + 1; j < contentDirectory.length; j++) {
                if (contentDirectory[i].getName().compareToIgnoreCase(contentDirectory[j].getName()) > 0) {
                    File temp = contentDirectory[i];
                    contentDirectory[i] = contentDirectory[j];
                    contentDirectory[j] = temp;
                }
            }
        }
    }
}
