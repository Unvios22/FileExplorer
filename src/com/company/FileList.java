package com.company;

import java.io.File;
import java.nio.file.Path;

public class FileList {

private File[] listOfFiles;

    public FileList(Path input) {
        File folder = new File(String.valueOf(input));
        listOfFiles = folder.listFiles();
        ListFiles(listOfFiles);

    }

    private void ListFiles(File[] listOfFiles) {

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Dir " + listOfFiles[i].getName());
            }

        }

    }
}

