package level1;
import model.DirectoryManager;
import view.DirectoryView;
import model.SerDesDirectory;
import java.io.*;
import java.util.Scanner;


public class Ex5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectoryView directoryView = new DirectoryView(scanner);

        System.out.println("Type the route of the file to serialize: ");
        String folderPath = scanner.nextLine();
        directoryView.getDirectoryManager().setFolderPath(folderPath);

        SerDesDirectory serDes = new SerDesDirectory(directoryView.getDirectoryManager());

        System.out.println("Type the name of the file with .ser extension:");
        String serFile =scanner.nextLine();

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serFile))){
            objectOutputStream.writeObject(serDes);
            System.out.println("Serialized object in " +serFile);
        }
        catch(IOException e){
            System.err.println("Error to serialize: "+ e.getMessage());
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serFile))) {
            SerDesDirectory serDes2 = (SerDesDirectory) objectInputStream.readObject();
            System.out.println("Deserialized object in: " +serDes2.getDirectoryManager().getFolderFilePath());
        }
        catch(IOException | ClassNotFoundException e){
            System.err.println("Error at deserialize " + e.getMessage());
        }
    }


}
