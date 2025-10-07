package level1;

import view.FileView;
import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileView fileView = new FileView(scanner);

        System.out.println("Type the router of the TXT file:");
        fileView.changeFilePath();

        fileView.readAndShowFile();
        scanner.close();
    }

}
