package com.ipro.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class charged to load and save information onto .csv file
 * 
 */
public class FileManager {
    private static FileOutputStream fop;
    public static String dirPath = File.separator;
    public static String fileExtension = ".csv";
    private static ArrayList<String> classNames = null;

    /**
     * Create file
     * @param pathName
     * @param columnNames
     */
    public static void createFile(String pathName, ArrayList<String> columnNames) {
        try {
            File file = new File(pathName);

            if (file.createNewFile()){
                fop = new FileOutputStream(file);
                String contentLine = String.join(";", columnNames) + "\n";
                fop.write(contentLine.getBytes());
                fop.flush();
                fop.close();
                System.out.println("\"" + pathName + "\" file is created!");
            } else{
                System.out.println("\"" + pathName + "\" file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a new line to specific file
     * @param fileName
     * @param content
     */
    public static void addRow(String fileName, String content) {
        String pathName = "." + dirPath + fileName + fileExtension;
        File file = new File(pathName);

        try {
            fop = new FileOutputStream(file);
            fop.write(content.getBytes());
            fop.flush();
            fop.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the next available row Id
     * @param fileName
     * @return
     */
    public static Integer getNextId(String fileName) {
        String pathName = "." + dirPath + fileName + fileExtension;
        File file = new File(pathName);
        Integer max = 0;

        try {
            Scanner sc = new Scanner(file);

            /**
             * Skip first line as it only contains column names (header)
             */
            sc.nextLine();

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] info = line.split(";");

                if (max < Integer.parseInt(info[0])) {
                    max = Integer.parseInt(info[0]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return max + 1;
    }
    
    /**
     * Loads data into the model using a filename and a class name
     * @return
     * @throws FileNotFoundException
     * @throws NumberFormatException
     * @throws NullPointerException
     * @param fileName
     * @param columnNames
     */
    public static ArrayList<String[]> load(String fileName, ArrayList<String> columnNames) throws FileNotFoundException, NumberFormatException, NullPointerException {
        String pathName = "." + dirPath + fileName + fileExtension;
        createFile(pathName, columnNames);
        ArrayList<String[]> collection = new ArrayList<>();
        File file = new File(pathName);

        try {
            Scanner sc = new Scanner(file);

            /**
             * Skip first line as it only contains column names (header)
             */
            sc.nextLine();

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] info = line.split(";");

                collection.add(info);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return collection;
    }
}
