package com.automator.handler;
import com.automator.exception.FileException;

import java.io.*;
import java.util.Scanner;

public class FileHandler {
    public File file;
    private Scanner sc;
    private FileWriter fw;

    public FileHandler(String pathname) throws FileException {
        try {
            File file = new File(pathname);
            Scanner sc = new Scanner(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public String readLine(){
        if (sc != null && sc.hasNext()){
            return sc.nextLine();
        } else {
            return null; // exception
        }
    }

    public Boolean exists(){
        return file != null && file.exists();
    }
//    create
    public void create(){
        try {
            file.createNewFile();
        } catch (IOException e){
            System.out.println("File already exists");
        }
    }
//    delete
    public void delete(){
        if (file != null && file.exists()){
            file.delete();
        }
    }
//    write
    public void write(String string){
        if(file != null){
            if (!file.exists()) {
                create();
            }
            if (fw == null) {
                try {
                    fw = new FileWriter(file, true);
                } catch (IOException e){
                    System.out.println("could not write instantiate FileWriter");
                }
            }
            try {
                fw.write(string);
            } catch (IOException e){
                System.out.println("Could not write to file");
            };
        } else {
            throw new FileException("file not specified");
        }
    }

    public void close(){
        if (sc != null) {
            sc.close();
        }
    }
}
