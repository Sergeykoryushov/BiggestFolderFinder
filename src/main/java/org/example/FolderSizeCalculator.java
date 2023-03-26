package org.example;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderSizeCalculator extends RecursiveTask<Long> {
    private File folder;

    public FolderSizeCalculator(File folder) {
        this.folder = folder;
    }

    @Override
    protected Long compute() {
        List<FolderSizeCalculator> subTasks = new LinkedList<>();
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File files[] = folder.listFiles();
        for (File file : files) {
            FolderSizeCalculator task = new FolderSizeCalculator(file);
            task.fork();
            subTasks.add(task);
        }

            for (FolderSizeCalculator task : subTasks ){
                sum += task.join();
            }
return sum;
    }
}
