package level1;

import view.DirectoryView;
import java.util.Scanner;

public class Ex1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectoryView directoryView = new DirectoryView(scanner);

        System.out.println("Enter the route of the file to list");
        directoryView.changeFolderPath();

        directoryView.showDirectorySimple();
        scanner.close();
    }


}
