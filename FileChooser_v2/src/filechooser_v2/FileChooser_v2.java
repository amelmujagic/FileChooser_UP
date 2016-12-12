package filechooser_v2;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Formatter;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class FileChooser_v2 {

    private static String JAVA = "java";
    private static char DOT = '.';
    
    
    public static void main(String[] args) {
         JFileChooser ch;
        File file, directory;
        int status;
        Formatter formatFile;

        ch = new JFileChooser();
        status = ch.showDialog(null, "Compile project!");

        try {
            if (status == JFileChooser.APPROVE_OPTION) {
                file = ch.getSelectedFile();
                directory = ch.getCurrentDirectory();

                // ovdje implementiraj ispis samo PDF.ova
                String[] listaFiles = directory.list();
                System.out.println("Lista fajlova u dir-u: ");
                System.out.println(Arrays.toString(listaFiles));

                System.out.println("Odabran je direktorij: " + directory.getName());
                System.out.println("i file: " + file.getName());
                System.out.println("sa putanjom " + file.getAbsolutePath());
                System.out.println("file canonical path. " + file.getCanonicalPath());
            } else {
                System.out.println("File-open dialog is canceled.");
            }
        } catch (Exception e) {
            System.out.println("It has an error while opening a file.");
        }
        System.out.println("\n\n");

        status = ch.showSaveDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            file = ch.getSelectedFile();
            directory = ch.getCurrentDirectory();
            System.out.println("Seected file for saving " + file.getName());
            System.out.println("in directory " + directory.getPath());
        } else {
            System.out.println("Save dialog is canceled.");
        }

    }
    
}
