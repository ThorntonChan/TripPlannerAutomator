package com.automator.handler;

import com.automator.exception.FileException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class LogHandler{
    private static BufferedWriter writer;

    public static void options(String pathname, Boolean append) throws FileException {
        try {
            FileHandler file = new File(pathname);
            writer = new BufferedWriter(new FileWriter(file, append));
        } catch (IOException e) {
            throw new FileException("Could not initialize LogHandler" ,e);
        }
    }

    public static void log(String entry){
        try {
            writer.write(entry);
        } catch (IOException e){
//            throw new FileException("Log entry unsuccessful", e);
            System.out.println("Log entry unsuccessful");
        }
    }

    public static void close() throws FileException {
        try {
            sc.close();
            writer.close();
        } catch (IOException e) {
            throw new FileException("LogHandler closure unsuccessful", e);
        }
    }
}
