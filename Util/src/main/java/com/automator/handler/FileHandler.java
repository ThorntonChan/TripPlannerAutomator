package com.automator.handler;
import com.automator.exception.FileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class FileHandler {
    protected static File file;
    protected static Scanner sc;

//    protected FileHandler(){};
    public static void read(String pathname) throws FileException {
        try {
            File file = new File(pathname);
            Scanner sc = new Scanner(file);
        } catch (IOException e){
            throw new FileException("Error Occurred while reading file", e);
        }
//        catch (FileNotFoundException e) {
//            throw new FileException("File not found", e);
//        }
    }
    private static Boolean hasNext(){
        return sc.hasNext();
    }
    public static String readLine(){
        if (sc.hasNext()){
            return sc.nextLine();
        } else {
            return ""; // exception
        }
    }
    public static void close() throws FileException {
        if (sc != null) {
            sc.close();
        }
    }
}
