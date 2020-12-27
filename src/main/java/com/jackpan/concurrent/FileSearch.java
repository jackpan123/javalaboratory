package com.jackpan.concurrent;

import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author jackpan
 * @version v1.0 2020/12/27 22:22
 */
public class FileSearch {

    public static final Set<String> fileNameSet = new HashSet<>();

    public static void main(String[] args) {
        File[] roots = new File[2];
        roots[0] = new File("/Users/jackpan/JackPanDocuments/lczy-documents/ldc-doc");
        roots[1] = new File("/Users/jackpan/JackPanDocuments/lczy-documents/ldh-doc");
        startIndexing(roots);
    }

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<>(5);
        FileFilter fileFilter = pathname -> true;

        for (File root : roots) {
            new Thread(new FileCrawler(queue, fileFilter, root)).start();
        }

        for (int i=0; i<3; ++i) {
            new Thread(new Indexer(queue)).start();
        }

        System.out.println("Sleep five seconds");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (File root : roots) {
            new Thread(new FileCrawler(queue, fileFilter, root)).start();
        }
    }

}
