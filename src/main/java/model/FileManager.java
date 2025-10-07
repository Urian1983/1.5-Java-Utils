package model;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private String filepath = "newFile.txt";

    private File file = new File(filepath);

    private ArrayList<String> clipBoard = new ArrayList<String>();

    public ArrayList<String> getClipBoard() {
        return clipBoard;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
        this.file = new File(filepath);
    }

    public File getFile() {
        return file;
    }

    public void read() {
        clipBoard.clear();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                clipBoard.add(line);
            }
        } catch (IOException e) {
            System.err.println("Impossible to read the file: " + e.getMessage());
        }
    }

    public void clearClipboard() {
        clipBoard.clear();
        System.out.println("Clipboard cleared");
    }

    public boolean write(ArrayList<String> lines) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            for (String line :lines){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("Impossible to write in the file: " + e.getMessage());
            return false;
        }
    }

    public boolean createNewFile (String fileName){
        try{
            File newFile = new File(fileName + ".txt");
            if (newFile.exists()) {
                System.out.println("File name already exists, choose another one");
                return false;
            } else {
                newFile.createNewFile();
                this.file = newFile;
                this.filepath = newFile.getPath();
                return true;
            }
        } catch (IOException e){
            System.err.println("Unable to create a new file: " + e.getMessage());
            return false;
        }
    }

}
