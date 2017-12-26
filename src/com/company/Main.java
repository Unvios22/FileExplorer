package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Input directory path");
        int stop = 0;
        Scanner in = new Scanner(System.in);
        ListFiles fileLister = new ListFiles();
        String[] inputArray;
        Path currentDir;
        Path relativePath;
        String s = in.next();
        currentDir = Paths.get(s);
        relativePath = currentDir;

        while (stop == 0) {
            if (!(s.equals(relativePath.toAbsolutePath().toString()))) {
                Path normalized = relativePath.toAbsolutePath().normalize();
                System.out.print(normalized);
            }

                s = in.nextLine();
                inputArray = s.split(" ");


            if (inputArray.length == 1 ){
                if (inputArray[0].equals("stop")){
                    stop++;
                    continue;
                }
                else if (inputArray[0].equals("ls"))
                    fileLister.ListFiles(relativePath.toAbsolutePath());

            }

            else if (inputArray.length == 2){
                if (inputArray[0].equals("cd")){
                    if (inputArray[1].contains(":")) {
                        currentDir = relativePath;
                        relativePath =  Paths.get(inputArray[1]);
                    } else {
                    currentDir = relativePath;
                    relativePath =  Paths.get(currentDir.toString(),inputArray[1]);
                    }

                }
            }

            else if (inputArray.length > 2){
                if (inputArray[0].equals("cd")) {
                    if (inputArray[1].contains(":")) {
                        currentDir = relativePath;
                        relativePath = Paths.get(readPath(inputArray));
                    }
                    else {
                        currentDir = relativePath;
                        relativePath = Paths.get(currentDir.toString(), readPath(inputArray));
                    }
                }

            }

        }

        }

        private static String readPath(String[] input){

            String output = "";

            for (int i = 1; i<input.length; i++){
                if (!(i == input.length - 1))
                output += input[i] + " ";

                else output += input[i];
            }



            return output;
        }
    }

