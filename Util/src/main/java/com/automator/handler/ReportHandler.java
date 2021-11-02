package com.automator.handler;

import com.automator.exception.FileException;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class ReportHandler {
    private static File file;
    private static FileWriter fw;

    public static Boolean init(String pathname, Boolean append){
        try {
            file = new File(pathname);
            fw = new FileWriter(file, append);
            return true;
        } catch (IOException e){
            System.out.println("could not initialise report file");
            e.printStackTrace();
            return false;
        }
    }

    public static void output(String entry){
            if (file != null ){
                try {
                    fw.write(entry);
                } catch (IOException e){
                    System.out.println("Could not be written to output file");
                }
            } else {
                System.out.println("Output file not specified");
            }
    }
}
