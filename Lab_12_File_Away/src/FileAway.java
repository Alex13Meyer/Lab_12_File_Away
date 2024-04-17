import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
public class FileAway {
    public static void main(String[] args) {
        //Create file chooser main
        JFileChooser J = new JFileChooser();
        //Open file dialog and get the users choice of file on their system
        int returnValue = J.showOpenDialog(null);
        //Makes sure user selects a file
        if (returnValue == J.APPROVE_OPTION) {
            //Get selected file
            File selectedFile = J.getSelectedFile();
            processFile(selectedFile);
        }
        else {
            System.out.println("File not selected.");
            //If no file is selected the program exits
        }
    }
    private static void processFile(File file) {
        //Process of file and variables for line/word/char count
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            //Reads each line from the file
            while ((line = reader.readLine()) !=null) {
                lineCount++;
                //Counts the lines
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
                //Counts the characters
            }
            //Out print for the report on the file
            System.out.println("Summary Report:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            //If there is a problem with the file an error message is to display
        }
    }
}
