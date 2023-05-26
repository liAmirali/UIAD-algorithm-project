package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    public final static String CARPET_PATTERN_FILE_PATH = "./files/1-1.txt";
    public final static String[] CARPETS_FILE_PATHS = {
            "./files/carpet0.txt",
            "./files/carpet1.txt",
            "./files/carpet2.txt",
            "./files/carpet3.txt",
            "./files/carpet4.txt",
            "./files/carpet5.txt",
            "./files/carpet6.txt"};

    public static ArrayList<String> readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner reader = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();
        while (reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
        reader.close();
        return lines;
    }
}
