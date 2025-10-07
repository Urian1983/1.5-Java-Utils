package level1;

import view.DirectoryView;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectoryView directoryView = new DirectoryView(scanner);

        System.out.println("Enter the route of the file that you want to show as a tree:");
        directoryView.changeFolderPath();

        System.out.println("Do you want to shoe it recursively? (true/false)");
        boolean recursive = Boolean.parseBoolean(scanner.nextLine());

        directoryView.showDirectoryDetailed(recursive);
        scanner.close();

    }
}
