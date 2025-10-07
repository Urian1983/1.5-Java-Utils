package view;

import model.DirectoryManager;
import java.io.File;
import java.util.Scanner;

public class DirectoryView {

    private DirectoryManager directoryManager;
    private Scanner sc;

    public DirectoryView(Scanner sc){
        this.directoryManager = new DirectoryManager();
        this.sc = sc;
    }

    public void changeFolderPath(){
        System.out.println("Write the name of the folder that you want to save");
        String newFolderPath = sc.nextLine();
        directoryManager.setFolderPath(newFolderPath);
    }

    public void createNewFolder(){
        System.out.println("Write the name of the new folder: ");
        String newFolderName = sc.nextLine();
        boolean eureka = directoryManager.createNewFolder(newFolderName);
        if(eureka){
            System.out.println("Folder created successfully");
        }
    }

    public void showDirectorySimple(){
        File[] contents = directoryManager.showDirectory();
        if (contents !=null){
            directoryManager.printDirectoryContents(contents);
        }
    }

    public void showDirectoryDetailed (boolean recursive){
        directoryManager.printDirectoryDetailed(recursive);
    }

    public void saveDirectoryToFile (boolean recursive){
        System.out.println("Enter the filename where yo want to store the Directory");
        String outPutFile = sc.nextLine();
        boolean eureka = directoryManager.saveDirectoryTreeToFile(outPutFile,recursive);
        if(eureka){
            System.out.println("Directory Tree saved succesfully");
        }

    }

    public DirectoryManager getDirectoryManager(){
        return directoryManager;
    }

}
