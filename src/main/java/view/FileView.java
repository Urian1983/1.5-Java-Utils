package view;

import model.FileManager;
import java.util.Scanner;
import java.util.ArrayList;
public class FileView {

    private FileManager fileManager;
    private Scanner sc;

    public FileView(Scanner sc){
        this.fileManager= new FileManager();
        this.sc= sc;
    }

    public void changeFilePath(){
        System.out.println("Write the name of the file that you want to save");
        String newFilePath= sc.nextLine();
        fileManager.setFilepath(newFilePath);
        System.out.println("Filepatch changed to:" +newFilePath);
    }

    public void createNewFile(){
        System.out.println("Write the name of the new file");
        String newFileName = sc.nextLine();
        boolean eureka = fileManager.createNewFile(newFileName);
        if(eureka){
            System.out.println("File created succesfully");
        }
    }

    public void writeToFile() {
        System.out.println("Write all that you want. If you want to save and close write ./");

        ArrayList<String> lines = new ArrayList<String>();
        String line;

        while (true) {
            line = sc.nextLine();
            if (line.equals("./")) {
                break;
            }
            lines.add(line);
        }

        boolean eureka = fileManager.write(lines);

        if (eureka) {
            System.out.println("The content has been saved");
        }
    }

    public void readAndShowFile(){
            fileManager.read();
            System.out.println("\n---File Contents---");
            for(String fileLine: fileManager.getClipBoard()){
                System.out.println(fileLine);
            }
        }

    public void clearClipboard(){
        fileManager.clearClipboard();
    }

    public FileManager getFileManager(){
        return fileManager;
    }



    }

