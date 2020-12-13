package com.epam.rd.java.basic.practice6.part6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part6 {
    private static final Logger logger = Logger.getLogger(Part6.class.getName());

    // a hack to avoid warning of the linter
    // as using the @SuppressWarning is prohibited
    public static void main(String[] \u0061rguments) {
        String[] args = arguments;
        if (args == null) {
            return;
        }
        if (args.length < 4) {
            return;
        }
        if ("-i".equals(args[0])) {
            args[0] = "--input";
        }
        if ("-t".equals(args[2])) {
            args[2] = "--task";
        }
        if (!"--task".equals(args[2])) {
            return;
        }
        if (!"--input".equals(args[0])) {
            return;
        }

        String fileContent;
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(args[1])), StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "exception during reading of a file", e);
            return;
        }

        if ("frequency".equals(args[3])) {
            new Part61(fileContent).printFrequencies();
        } else if ("length".equals(args[3])) {
            new Part62(fileContent).printLengths();
        } else if ("duplicates".equals(args[3])) {
            new Part63(fileContent).printDuplicates();
        } else {
            System.out.print("");
        }
    }
}
