package chapter1.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class Exercise_43 {
    public static void main(String[] args) {
        String folderPath = args[0];
        File folder = new File(folderPath);
        Queue<String> files = new Queue<>();

        parseDirectory(folder, 0, files);

        for(String fileName : files) StdOut.println(fileName);
    }

    private static void parseDirectory(File file, int level, Queue<String> files) {
        if (file == null) return;

        files.enqueue(formatFileName(file, level));

        File[] fileList = file.listFiles();

        if (fileList == null) return;

        int nextLevel = level + 1;
        for(File fileItem : fileList) {
            if (fileItem.isFile()) {
                files.enqueue(formatFileName(fileItem, nextLevel));
            } else if (fileItem.isDirectory()) {
                parseDirectory(fileItem, nextLevel, files);
            }
        }
    }

    private static String formatFileName(File file, int level) {
        return "  ".repeat(level) + file.getName();
    }
}
