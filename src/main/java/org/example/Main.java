package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            String folderPath = "C:\\Users\\Сергей\\Desktop\\Вика";
            File file = new File(folderPath);
            System.out.println(getFolderSize(file));
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
            File files[] = folder.listFiles();
            for (File file : files) {
                sum += getFolderSize(file);
            }
        return sum;
    }
}