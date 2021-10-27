package com.automator.handler;

import com.automator.exception.FileException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class ReportHandler {
    public static void output(FileHandler fileHandler, String entry){
            fileHandler.write(entry);
    }
}
