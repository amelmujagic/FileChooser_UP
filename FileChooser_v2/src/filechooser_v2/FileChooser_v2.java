package filechooser_v2;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Formatter;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class FileChooser_v2 extends FileFilter {

    private static String JAVA = "java";
    private static char DOT = '.';
    private static String PDF = "pdf";

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
                System.out.println("List files from directory: ");
                System.out.println(Arrays.toString(listaFiles));

                System.out.println("Directory picked: " + directory.getName());
                System.out.println("and file picked: " + file.getName());
                System.out.println("with path " + file.getAbsolutePath());
                System.out.println("and finally with file canonical path. " + file.getCanonicalPath());
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

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        if (extension(f) == JAVA) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        String extDescription = "Java source files (.java)";
        return extDescription;
    }

    private String extension(File f) {
        String filename = f.getName();
        int no = filename.indexOf(DOT);
        String ext = filename.substring(no, filename.length());
        return ext;
    }

}
