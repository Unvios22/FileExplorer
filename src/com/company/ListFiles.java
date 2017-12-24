package com.company;

import java.nio.file.Path;

public class ListFiles {

  public ListFiles() {

    }


    public FileList ListFiles(Path input){
        FileList fileLister = new FileList(input);
        return fileLister;
    }


}