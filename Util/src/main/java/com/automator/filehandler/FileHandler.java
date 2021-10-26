package com.automator.filehandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileHandler {
    Scanner sc;
    public FileHandler(String pathname) {
        try {
            File file = new File(pathname);
            Scanner sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
    public Boolean hasNext(){
        return sc.hasNext();
    }
    public String readLine(){
        if (sc.hasNext()){
            return sc.nextLine();
        } else {
            return ""; // exception
        }
    }
}
