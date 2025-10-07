package level1;

import view.DirectoryView;
import java.util.Scanner;
public class Ex3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DirectoryView directoryView = new DirectoryView(scanner);

        System.out.println("Type the route of the directory");
        directoryView.changeFolderPath();

        System.out.println("Type the name of the file for the output");
        directoryView.saveDirectoryToFile(true);

        scanner.close();;

    }
}
