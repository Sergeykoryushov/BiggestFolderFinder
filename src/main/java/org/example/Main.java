package org.example;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        try {
            String folderPath = "C:\\Users\\Сергей\\Desktop";
            File file = new File(folderPath);
            FolderSizeCalculator calculator = new FolderSizeCalculator(file);
            ForkJoinPool pool = new ForkJoinPool();
           long size = pool.invoke(calculator);
            System.out.println(size);
//            System.out.println(getFolderSize(file));
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